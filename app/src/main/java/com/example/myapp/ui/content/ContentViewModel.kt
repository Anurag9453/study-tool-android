package com.example.myapp.ui.content

import androidx.lifecycle.ViewModel
import com.example.myapp.data.model.ContentBlock
import com.example.myapp.data.model.Question
import com.example.myapp.data.repository.ContentRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ContentViewModel(
    contentRepository: ContentRepository,
    moduleId: String
) : ViewModel() {

    private val _contentBlocks = MutableStateFlow(contentRepository.getContentBlocks(moduleId))
    val contentBlocks: StateFlow<List<ContentBlock>> = _contentBlocks

    private val _questions = MutableStateFlow(contentRepository.getQuestions(moduleId))
    val questions: StateFlow<List<Question>> = _questions

    private val _selectedAnswers = MutableStateFlow<Map<String, String>>(emptyMap())
    val selectedAnswers: StateFlow<Map<String, String>> = _selectedAnswers

    private val _isSubmitted = MutableStateFlow(false)
    val isSubmitted: StateFlow<Boolean> = _isSubmitted

    private val _score = MutableStateFlow<Int?>(null)
    val score: StateFlow<Int?> = _score

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
