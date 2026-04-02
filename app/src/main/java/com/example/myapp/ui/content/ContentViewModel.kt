package com.example.myapp.ui.content

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapp.data.model.ContentBlock
import com.example.myapp.data.model.Question
import com.example.myapp.data.repository.ContentRepository
import com.example.myapp.data.scoring.ScoringRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ContentViewModel(
    contentRepository: ContentRepository,
    private val moduleId: String,
    private val scoringRepository: ScoringRepository
) : ViewModel() {

    private val _contentBlocks = MutableStateFlow(contentRepository.getContentBlocks(moduleId))
    val contentBlocks: StateFlow<List<ContentBlock>> = _contentBlocks

    private val _questions = MutableStateFlow(contentRepository.getQuestions(moduleId))
    val questions: StateFlow<List<Question>> = _questions

    private val _selectedAnswers = MutableStateFlow<Map<String, String>>(emptyMap())
    val selectedAnswers: StateFlow<Map<String, String>> = _selectedAnswers

    private val _isChecked = MutableStateFlow(false)
    val isChecked: StateFlow<Boolean> = _isChecked

    private val _isCompleted = MutableStateFlow(false)
    val isCompleted: StateFlow<Boolean> = _isCompleted

    private val _score = MutableStateFlow<Int?>(null)
    val score: StateFlow<Int?> = _score

    private val _attemptNumber = MutableStateFlow(1)
    val attemptNumber: StateFlow<Int> = _attemptNumber

    private val _pointsAwarded = MutableStateFlow<Int?>(null)
    val pointsAwarded: StateFlow<Int?> = _pointsAwarded

    private val _alreadyCompleted = MutableStateFlow(false)
    val alreadyCompleted: StateFlow<Boolean> = _alreadyCompleted

    val totalPoints: StateFlow<Int> = scoringRepository.totalPoints
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), 0)

    val allAnswered: StateFlow<Boolean> = _selectedAnswers.map { answers ->
        _questions.value.all { it.id in answers }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), false)

    init {
        viewModelScope.launch {
            // Check if module was already completed
            scoringRepository.getModuleScore(moduleId).collect { moduleScore ->
                if (moduleScore != null && moduleScore.isCompleted) {
                    _alreadyCompleted.value = true
                    _isCompleted.value = true
                    _pointsAwarded.value = moduleScore.points
                    _attemptNumber.value = moduleScore.attempts
                    // Show all correct answers for review
                    val correctAnswers = _questions.value.associate { it.id to it.correctOptionId }
                    _selectedAnswers.value = correctAnswers
                    _score.value = _questions.value.size
                    _isChecked.value = true
                    return@collect
                }
                // Load current attempt count for incomplete module
                val attempts = scoringRepository.getAttemptCount(moduleId)
                if (attempts > 0) {
                    _attemptNumber.value = attempts + 1
                }
            }
        }
    }

    fun onOptionSelected(questionId: String, optionId: String) {
        if (_isCompleted.value) return
        if (_isChecked.value) return // Must click retry first
        _selectedAnswers.value = _selectedAnswers.value + (questionId to optionId)
    }

    fun onSubmit() {
        val answers = _selectedAnswers.value
        val qs = _questions.value
        val correctCount = qs.count { q -> answers[q.id] == q.correctOptionId }
        val currentAttempt = _attemptNumber.value

        _score.value = correctCount
        _isChecked.value = true

        viewModelScope.launch {
            scoringRepository.incrementAttempt(moduleId)
        }

        if (correctCount == qs.size) {
            val points = ScoringRepository.calculatePoints(currentAttempt)
            _pointsAwarded.value = points
            _isCompleted.value = true
            viewModelScope.launch {
                scoringRepository.saveModuleScore(moduleId, points, currentAttempt)
            }
        }
    }

    fun onRetry() {
        _attemptNumber.value = _attemptNumber.value + 1
        _isChecked.value = false
        _score.value = null
        // Keep selected answers — user only fixes wrong ones
    }
}
