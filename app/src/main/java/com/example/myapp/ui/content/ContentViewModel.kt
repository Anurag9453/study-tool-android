package com.example.myapp.ui.content

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapp.data.model.ContentBlock
import com.example.myapp.data.model.Question
import com.example.myapp.data.repository.ContentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ContentViewModel(
    private val contentRepository: ContentRepository,
    private val moduleId: String
) : ViewModel() {

    val moduleTitle: String = contentRepository.getModuleTitle(moduleId)

    private val _contentBlocks = MutableStateFlow<List<ContentBlock>>(emptyList())
    val contentBlocks: StateFlow<List<ContentBlock>> = _contentBlocks

    private val _questions = MutableStateFlow<List<Question>>(emptyList())
    val questions: StateFlow<List<Question>> = _questions

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _selectedAnswers = MutableStateFlow<Map<String, String>>(emptyMap())
    val selectedAnswers: StateFlow<Map<String, String>> = _selectedAnswers

    private val _isSubmitted = MutableStateFlow(false)
    val isSubmitted: StateFlow<Boolean> = _isSubmitted

    private val _score = MutableStateFlow<Int?>(null)
    val score: StateFlow<Int?> = _score

    init {
        viewModelScope.launch {
            val blocks = withContext(Dispatchers.Default) {
                contentRepository.getContentBlocks(moduleId)
            }
            val qs = withContext(Dispatchers.Default) {
                contentRepository.getQuestions(moduleId)
            }
            _contentBlocks.value = blocks
            _questions.value = qs
            _isLoading.value = false
        }
    }

    fun onOptionSelected(questionId: String, optionId: String) {
        if (_isSubmitted.value) return
        _selectedAnswers.value = _selectedAnswers.value + (questionId to optionId)
    }

    fun onSubmit() {
        val answers = _selectedAnswers.value
        val qs = _questions.value
        val correct = qs.count { q -> answers[q.id] == q.correctOptionId }
        _score.value = correct
        _isSubmitted.value = true
    }

    val allAnswered: Boolean
        get() = _questions.value.all { it.id in _selectedAnswers.value }
}
