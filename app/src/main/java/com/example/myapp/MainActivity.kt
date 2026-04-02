package com.example.myapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.compose.rememberNavController
import com.example.myapp.data.preferences.UserPreferencesRepository
import com.example.myapp.data.repository.HardcodedContentRepository
import com.example.myapp.data.scoring.ScoringRepository
import com.example.myapp.navigation.AppNavGraph
import com.example.myapp.ui.theme.MyAppTheme

private val Context.dataStore by preferencesDataStore(name = "user_prefs")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val contentRepository = HardcodedContentRepository()
        val userPreferencesRepository = UserPreferencesRepository(dataStore)
        val scoringRepository = ScoringRepository(dataStore)

        enableEdgeToEdge()
        setContent {
            MyAppTheme {
                val navController = rememberNavController()
                AppNavGraph(
                    navController = navController,
                    contentRepository = contentRepository,
                    userPreferencesRepository = userPreferencesRepository,
                    scoringRepository = scoringRepository
                )
            }
        }
    }
}
