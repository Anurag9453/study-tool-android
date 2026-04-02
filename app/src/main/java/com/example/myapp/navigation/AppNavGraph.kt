package com.example.myapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myapp.data.preferences.UserPreferencesRepository
import com.example.myapp.data.repository.ContentRepository
import com.example.myapp.data.scoring.ScoringRepository
import com.example.myapp.ui.language.LanguageSelectionScreen
import com.example.myapp.ui.language.LanguageSelectionViewModel
import com.example.myapp.ui.classselection.ClassSelectionScreen
import com.example.myapp.ui.classselection.ClassSelectionViewModel
import com.example.myapp.ui.subjectselection.SubjectSelectionScreen
import com.example.myapp.ui.subjectselection.SubjectSelectionViewModel
import com.example.myapp.ui.chapterlist.ChapterListScreen
import com.example.myapp.ui.chapterlist.ChapterListViewModel
import com.example.myapp.ui.modulelist.ModuleListScreen
import com.example.myapp.ui.modulelist.ModuleListViewModel
import com.example.myapp.ui.content.ContentScreen
import com.example.myapp.ui.content.ContentViewModel
import com.example.myapp.ui.leaderboard.LeaderboardScreen
import com.example.myapp.ui.leaderboard.LeaderboardViewModel
import com.example.myapp.ui.splash.SplashScreen
import com.example.myapp.ui.userprofile.UserProfileScreen
import com.example.myapp.ui.userprofile.UserProfileViewModel

@Composable
fun AppNavGraph(
    navController: NavHostController,
    contentRepository: ContentRepository,
    userPreferencesRepository: UserPreferencesRepository,
    scoringRepository: ScoringRepository
) {
    val hasCompletedProfile by userPreferencesRepository.hasCompletedProfile
        .collectAsState(initial = null)
    val hasCompletedOnboarding by userPreferencesRepository.hasCompletedOnboarding
        .collectAsState(initial = null)
    val userName by userPreferencesRepository.firstName
        .collectAsState(initial = null)
    val lastName by userPreferencesRepository.lastName
        .collectAsState(initial = "")
    val userRoleEnum by userPreferencesRepository.userRole
        .collectAsState(initial = null)

    val coroutineScope = rememberCoroutineScope()

    if (hasCompletedProfile == null || hasCompletedOnboarding == null) return

    val firstName = userName ?: ""
    val onLogout: () -> Unit = {
        coroutineScope.launch {
            userPreferencesRepository.clearAll()
            navController.navigate(Screen.Splash.route) {
                popUpTo(0) { inclusive = true }
            }
        }
    }

    val onLeaderboardClick: () -> Unit = {
        navController.navigate(Screen.Leaderboard.route)
    }

    val totalPoints by scoringRepository.totalPoints.collectAsState(initial = 0)

    val onBackClick: () -> Unit = {
        navController.popBackStack()
    }

    val nextDestination = when {
        hasCompletedProfile != true -> Screen.UserProfile.route
        hasCompletedOnboarding != true -> Screen.LanguageSelection.route
        else -> Screen.ClassSelection.route
    }

    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            SplashScreen(
                userName = if (hasCompletedProfile == true) userName else null,
                onSplashFinished = {
                    navController.navigate(nextDestination) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.UserProfile.route) {
            val vm = viewModel<UserProfileViewModel> {
                UserProfileViewModel(userPreferencesRepository)
            }
            UserProfileScreen(
                viewModel = vm,
                onProfileSaved = {
                    navController.navigate(Screen.LanguageSelection.route) {
                        popUpTo(Screen.UserProfile.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.LanguageSelection.route) {
            val vm = viewModel<LanguageSelectionViewModel> {
                LanguageSelectionViewModel(userPreferencesRepository)
            }
            LanguageSelectionScreen(
                viewModel = vm,
                onLanguageSelected = {
                    navController.navigate(Screen.ClassSelection.route) {
                        popUpTo(Screen.LanguageSelection.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.ClassSelection.route) {
            val vm = viewModel<ClassSelectionViewModel> {
                ClassSelectionViewModel(contentRepository, userPreferencesRepository)
            }
            ClassSelectionScreen(
                viewModel = vm,
                firstName = firstName,
                lastName = lastName ?: "",
                userRole = userRoleEnum?.name ?: "",
                onLogout = onLogout,
                onLeaderboardClick = onLeaderboardClick,
                totalPoints = totalPoints,
                onClassSelected = { classId ->
                    navController.navigate(Screen.SubjectSelection.createRoute(classId))
                }
            )
        }

        composable(
            route = Screen.SubjectSelection.route,
            arguments = listOf(navArgument("classId") { type = NavType.IntType })
        ) { backStackEntry ->
            val classId = backStackEntry.arguments?.getInt("classId") ?: 6
            val vm = viewModel<SubjectSelectionViewModel> {
                SubjectSelectionViewModel(contentRepository)
            }
            SubjectSelectionScreen(
                viewModel = vm,
                classId = classId,
                firstName = firstName,
                lastName = lastName ?: "",
                userRole = userRoleEnum?.name ?: "",
                onLogout = onLogout,
                onLeaderboardClick = onLeaderboardClick,
                onBackClick = onBackClick,
                totalPoints = totalPoints,
                onSubjectSelected = { subjectId ->
                    navController.navigate(Screen.ChapterList.createRoute(classId, subjectId))
                }
            )
        }

        composable(
            route = Screen.ChapterList.route,
            arguments = listOf(
                navArgument("classId") { type = NavType.IntType },
                navArgument("subjectId") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val classId = backStackEntry.arguments?.getInt("classId") ?: 6
            val subjectId = backStackEntry.arguments?.getString("subjectId") ?: "maths"
            val vm = viewModel<ChapterListViewModel> {
                ChapterListViewModel(contentRepository, classId, subjectId)
            }
            ChapterListScreen(
                viewModel = vm,
                firstName = firstName,
                lastName = lastName ?: "",
                userRole = userRoleEnum?.name ?: "",
                onLogout = onLogout,
                onLeaderboardClick = onLeaderboardClick,
                onBackClick = onBackClick,
                totalPoints = totalPoints,
                onChapterSelected = { chapterId ->
                    navController.navigate(Screen.ModuleList.createRoute(chapterId))
                }
            )
        }

        composable(
            route = Screen.ModuleList.route,
            arguments = listOf(navArgument("chapterId") { type = NavType.StringType })
        ) { backStackEntry ->
            val chapterId = backStackEntry.arguments?.getString("chapterId") ?: ""
            val vm = viewModel<ModuleListViewModel> {
                ModuleListViewModel(contentRepository, chapterId, scoringRepository)
            }
            ModuleListScreen(
                viewModel = vm,
                firstName = firstName,
                lastName = lastName ?: "",
                userRole = userRoleEnum?.name ?: "",
                onLogout = onLogout,
                onLeaderboardClick = onLeaderboardClick,
                onBackClick = onBackClick,
                totalPoints = totalPoints,
                onModuleSelected = { moduleId ->
                    navController.navigate(Screen.Content.createRoute(moduleId))
                }
            )
        }

        composable(
            route = Screen.Content.route,
            arguments = listOf(navArgument("moduleId") { type = NavType.StringType })
        ) { backStackEntry ->
            val moduleId = backStackEntry.arguments?.getString("moduleId") ?: ""
            val vm = viewModel<ContentViewModel> {
                ContentViewModel(contentRepository, moduleId, scoringRepository)
            }
            ContentScreen(
                viewModel = vm,
                firstName = firstName,
                lastName = lastName ?: "",
                userRole = userRoleEnum?.name ?: "",
                onLogout = onLogout,
                onLeaderboardClick = onLeaderboardClick,
                onBackClick = onBackClick,
                totalPoints = totalPoints
            )
        }

        composable(Screen.Leaderboard.route) {
            val vm = viewModel<LeaderboardViewModel> {
                LeaderboardViewModel(
                    scoringRepository = scoringRepository,
                    currentUserName = "$firstName ${lastName ?: ""}".trim()
                )
            }
            LeaderboardScreen(
                viewModel = vm,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
