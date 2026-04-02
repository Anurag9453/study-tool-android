package com.example.myapp.data.scoring

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

data class ModuleScore(
    val moduleId: String,
    val points: Int,
    val attempts: Int,
    val isCompleted: Boolean
)

class ScoringRepository(private val dataStore: DataStore<Preferences>) {

    fun getModuleScore(moduleId: String): Flow<ModuleScore?> = dataStore.data.map { prefs ->
        val completed = prefs[booleanPreferencesKey("score_completed_$moduleId")] ?: false
        if (!completed) null
        else ModuleScore(
            moduleId = moduleId,
            points = prefs[intPreferencesKey("score_points_$moduleId")] ?: 0,
            attempts = prefs[intPreferencesKey("score_attempts_$moduleId")] ?: 1,
            isCompleted = true
        )
    }

    suspend fun getAttemptCount(moduleId: String): Int {
        val prefs = dataStore.data.first()
        return prefs[intPreferencesKey("score_attempts_$moduleId")] ?: 0
    }

    suspend fun incrementAttempt(moduleId: String): Int {
        dataStore.edit { prefs ->
            val current = prefs[intPreferencesKey("score_attempts_$moduleId")] ?: 0
            prefs[intPreferencesKey("score_attempts_$moduleId")] = current + 1
        }
        return dataStore.data.first()[intPreferencesKey("score_attempts_$moduleId")] ?: 1
    }

    suspend fun saveModuleScore(moduleId: String, points: Int, attemptNumber: Int) {
        dataStore.edit { prefs ->
            prefs[intPreferencesKey("score_points_$moduleId")] = points
            prefs[intPreferencesKey("score_attempts_$moduleId")] = attemptNumber
            prefs[booleanPreferencesKey("score_completed_$moduleId")] = true
        }
    }

    fun getPointsForAllModules(): Flow<Map<String, ModuleScore>> = dataStore.data.map { prefs ->
        prefs.asMap()
            .filterKeys { it.name.startsWith("score_completed_") }
            .filter { (it.value as? Boolean) == true }
            .map { (key, _) ->
                val moduleId = key.name.removePrefix("score_completed_")
                val points = prefs[intPreferencesKey("score_points_$moduleId")] ?: 0
                val attempts = prefs[intPreferencesKey("score_attempts_$moduleId")] ?: 1
                moduleId to ModuleScore(moduleId, points, attempts, true)
            }
            .toMap()
    }

    val totalPoints: Flow<Int> = dataStore.data.map { prefs ->
        prefs.asMap()
            .filterKeys { it.name.startsWith("score_points_") }
            .values
            .filterIsInstance<Int>()
            .sum()
    }

    companion object {
        fun calculatePoints(attemptNumber: Int): Int = when (attemptNumber) {
            1 -> 100
            2 -> 50
            else -> 25
        }
    }
}
