package com.example.myapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.compose.rememberNavController
import com.example.myapp.data.preferences.UserPreferencesRepository
import com.example.myapp.data.repository.ContentRepository
import com.example.myapp.data.repository.HardcodedContentRepository
import com.example.myapp.navigation.AppNavGraph
import com.example.myapp.ui.theme.MyAppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private val Context.dataStore by preferencesDataStore(name = "user_prefs")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userPreferencesRepository = UserPreferencesRepository(dataStore)

        enableEdgeToEdge()
        setContent {
            MyAppTheme {
                var contentRepository: ContentRepository? by remember { mutableStateOf(null) }
                val navController = rememberNavController()

                LaunchedEffect(Unit) {
                    contentRepository = withContext(Dispatchers.Default) {
                        HardcodedContentRepository()
                    }
                }

                val repo = contentRepository
                if (repo != null) {
                    AppNavGraph(
                        navController = navController,
                        contentRepository = repo,
                        userPreferencesRepository = userPreferencesRepository
                    )
                } else {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}
