package com.example.myapp.ui.userprofile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapp.data.model.UserRole
import com.example.myapp.data.preferences.UserPreferencesRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserProfileViewModel(
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {

    private val _firstName = MutableStateFlow("")
    val firstName: StateFlow<String> = _firstName

    private val _lastName = MutableStateFlow("")
    val lastName: StateFlow<String> = _lastName

    private val _selectedRole = MutableStateFlow<UserRole?>(null)
    val selectedRole: StateFlow<UserRole?> = _selectedRole

    private val _hasAttemptedSubmit = MutableStateFlow(false)
    val hasAttemptedSubmit: StateFlow<Boolean> = _hasAttemptedSubmit

    private val _navigationEvent = MutableSharedFlow<Unit>()
    val navigationEvent: SharedFlow<Unit> = _navigationEvent

    fun onFirstNameChanged(value: String) {
        _firstName.value = value
    }

    fun onLastNameChanged(value: String) {
        _lastName.value = value
    }

    fun onRoleSelected(role: UserRole) {
        _selectedRole.value = role
    }

    fun onSave() {
        _hasAttemptedSubmit.value = true

        val first = _firstName.value.trim()
        val last = _lastName.value.trim()
        val role = _selectedRole.value

        if (first.isBlank() || last.isBlank() || role == null) return

        viewModelScope.launch {
            userPreferencesRepository.saveUserProfile(first, last, role)
            _navigationEvent.emit(Unit)
        }
    }
}
