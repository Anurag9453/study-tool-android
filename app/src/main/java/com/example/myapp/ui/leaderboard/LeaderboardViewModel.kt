package com.example.myapp.ui.leaderboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapp.data.scoring.ScoringRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

data class LeaderboardEntry(
    val rank: Int,
    val name: String,
    val points: Int,
    val isCurrentUser: Boolean
)

class LeaderboardViewModel(
    scoringRepository: ScoringRepository,
    private val currentUserName: String
) : ViewModel() {

    // Dummy students with hardcoded scores
    private val dummyStudents = listOf(
        "Aarav Sharma" to 475,
        "Priya Patel" to 400,
        "Rohan Gupta" to 350,
        "Ananya Singh" to 300,
        "Vikram Reddy" to 275,
        "Sneha Iyer" to 250,
        "Arjun Nair" to 200,
        "Kavya Menon" to 175,
        "Rahul Verma" to 125,
        "Divya Joshi" to 100
    )

    val leaderboard: StateFlow<List<LeaderboardEntry>> =
        scoringRepository.totalPoints.combine(MutableStateFlow(dummyStudents)) { userPoints, dummies ->
            val allEntries = dummies.map { (name, pts) ->
                LeaderboardEntry(rank = 0, name = name, points = pts, isCurrentUser = false)
            } + LeaderboardEntry(rank = 0, name = currentUserName, points = userPoints, isCurrentUser = true)

            allEntries
                .sortedByDescending { it.points }
                .mapIndexed { index, entry ->
                    entry.copy(rank = index + 1)
                }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
}
