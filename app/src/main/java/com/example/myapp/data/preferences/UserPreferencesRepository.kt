package com.example.myapp.data.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import com.example.myapp.data.model.Language
import com.example.myapp.data.model.UserRole
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferencesRepository(private val dataStore: DataStore<Preferences>) {

    val selectedLanguage: Flow<Language?> = dataStore.data.map { prefs ->
        prefs[KEY_LANGUAGE]?.let { Language.valueOf(it) }
    }

    val selectedClassId: Flow<Int?> = dataStore.data.map { prefs ->
        prefs[KEY_CLASS_ID]
    }

    val hasCompletedOnboarding: Flow<Boolean> = dataStore.data.map { prefs ->
        prefs[KEY_ONBOARDING_COMPLETE] ?: false
    }

    val hasCompletedProfile: Flow<Boolean> = dataStore.data.map { prefs ->
        prefs[KEY_PROFILE_COMPLETE] ?: false
    }

    val firstName: Flow<String?> = dataStore.data.map { prefs -> prefs[KEY_FIRST_NAME] }
    val lastName: Flow<String?> = dataStore.data.map { prefs -> prefs[KEY_LAST_NAME] }
    val userRole: Flow<UserRole?> = dataStore.data.map { prefs ->
        prefs[KEY_USER_ROLE]?.let { UserRole.valueOf(it) }
    }

    suspend fun saveLanguage(language: Language) {
        dataStore.edit { prefs ->
            prefs[KEY_LANGUAGE] = language.name
        }
    }

    suspend fun saveClassId(classId: Int) {
        dataStore.edit { prefs ->
            prefs[KEY_CLASS_ID] = classId
        }
    }

    suspend fun setOnboardingComplete() {
        dataStore.edit { prefs ->
            prefs[KEY_ONBOARDING_COMPLETE] = true
        }
    }

    suspend fun saveUserProfile(firstName: String, lastName: String, role: UserRole) {
        dataStore.edit { prefs ->
            prefs[KEY_FIRST_NAME] = firstName
            prefs[KEY_LAST_NAME] = lastName
            prefs[KEY_USER_ROLE] = role.name
            prefs[KEY_PROFILE_COMPLETE] = true
        }
    }

    suspend fun clearAll() {
        dataStore.edit { it.clear() }
    }

    private companion object {
        val KEY_LANGUAGE = stringPreferencesKey("selected_language")
        val KEY_CLASS_ID = intPreferencesKey("selected_class_id")
        val KEY_ONBOARDING_COMPLETE = booleanPreferencesKey("onboarding_complete")
        val KEY_FIRST_NAME = stringPreferencesKey("first_name")
        val KEY_LAST_NAME = stringPreferencesKey("last_name")
        val KEY_USER_ROLE = stringPreferencesKey("user_role")
        val KEY_PROFILE_COMPLETE = booleanPreferencesKey("profile_complete")
    }
}
