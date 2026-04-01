package com.example.myapp.ui.language

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapp.data.model.Language
import com.example.myapp.data.preferences.UserPreferencesRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class LanguageSelectionViewModel(
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {

    private val _navigationEvent = MutableSharedFlow<Unit>()
    val navigationEvent: SharedFlow<Unit> = _navigationEvent

    fun onLanguageSelected(language: Language) {
        viewModelScope.launch {
            userPreferencesRepository.saveLanguage(language)
            userPreferencesRepository.setOnboardingComplete()
            _navigationEvent.emit(Unit)
        }
    }
}
