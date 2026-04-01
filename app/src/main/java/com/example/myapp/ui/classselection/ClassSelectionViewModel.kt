package com.example.myapp.ui.classselection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapp.data.model.SchoolClass
import com.example.myapp.data.preferences.UserPreferencesRepository
import com.example.myapp.data.repository.ContentRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ClassSelectionViewModel(
    contentRepository: ContentRepository,
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {

    private val _classes = MutableStateFlow(contentRepository.getClasses())
    val classes: StateFlow<List<SchoolClass>> = _classes

    fun onClassSelected(classId: Int) {
        viewModelScope.launch {
            userPreferencesRepository.saveClassId(classId)
        }
    }
}
