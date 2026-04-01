package com.example.myapp.ui.subjectselection

import androidx.lifecycle.ViewModel
import com.example.myapp.data.model.Subject
import com.example.myapp.data.repository.ContentRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SubjectSelectionViewModel(
    contentRepository: ContentRepository
) : ViewModel() {

    private val _subjects = MutableStateFlow(contentRepository.getSubjects())
    val subjects: StateFlow<List<Subject>> = _subjects
}
