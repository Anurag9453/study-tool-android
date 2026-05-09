package com.example.myapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myapp.data.model.Section
import com.example.myapp.data.preferences.UserPreferencesRepository
import com.example.myapp.ui.qa.QAScreen
import com.example.myapp.ui.qa.QAViewModel
import com.example.myapp.data.repository.ContentRepository
import com.example.myapp.ui.language.LanguageSelectionScreen
import com.example.myapp.ui.language.LanguageSelectionViewModel
import com.example.myapp.ui.classselection.ClassSelectionScreen
import com.example.myapp.ui.classselection.ClassSelectionViewModel
import com.example.myapp.ui.sectionselection.SectionSelectionScreen
import com.example.myapp.ui.subjectselection.SubjectSelectionScreen
import com.example.myapp.ui.subjectselection.SubjectSelectionViewModel
import com.example.myapp.ui.chapterlist.ChapterListScreen
import com.example.myapp.ui.chapterlist.ChapterListViewModel
import com.example.myapp.ui.modulelist.ModuleListScreen
import com.example.myapp.ui.modulelist.ModuleListViewModel
import com.example.myapp.ui.content.ContentScreen
import com.example.myapp.ui.content.ContentViewModel
import com.example.myapp.ui.splash.SplashScreen
import com.example.myapp.ui.userprofile.UserProfileScreen
import com.example.myapp.ui.userprofile.UserProfileViewModel

@Composable
fun AppNavGraph(
    navController: NavHostController,
    contentRepository: ContentRepository,
    userPreferencesRepository: UserPreferencesRepository
) {
    val hasCompletedProfile by userPreferencesRepository.hasCompletedProfile
        .collectAsState(initial = null)
    val hasCompletedOnboarding by userPreferencesRepository.hasCompletedOnboarding
        .collectAsState(initial = null)
    val userName by userPreferencesRepository.firstName
        .collectAsState(initial = null)

    if (hasCompletedProfile == null || hasCompletedOnboarding == null) return

    val nextDestination = when {
        hasCompletedProfile != true -> Screen.UserProfile.route
        hasCompletedOnboarding != true -> Screen.LanguageSelection.route
        else -> Screen.SectionSelection.route
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
                    navController.navigate(Screen.SectionSelection.route) {
                        popUpTo(Screen.LanguageSelection.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.SectionSelection.route) {
            SectionSelectionScreen(
                onSectionSelected = { section ->
                    when (section) {
                        Section.SCHOOL -> navController.navigate(Screen.ClassSelection.route)
                        Section.IT -> navController.navigate(
                            Screen.SubjectSelection.createRoute(0, Section.IT.id)
                        )
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
                onClassSelected = { classId ->
                    navController.navigate(
                        Screen.SubjectSelection.createRoute(classId, Section.SCHOOL.id)
                    )
                }
            )
        }

        composable(
            route = Screen.SubjectSelection.route,
            arguments = listOf(
                navArgument("classId") { type = NavType.IntType },
                navArgument("section") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val classId = backStackEntry.arguments?.getInt("classId") ?: 6
            val section = backStackEntry.arguments?.getString("section") ?: Section.SCHOOL.id
            val vm = viewModel<SubjectSelectionViewModel>(key = section) {
                SubjectSelectionViewModel(contentRepository, section)
            }
            SubjectSelectionScreen(
                viewModel = vm,
                classId = classId,
                section = section,
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
                subjectId = subjectId,
                onChapterSelected = { chapterId ->
                    navController.navigate(Screen.ModuleList.createRoute(chapterId))
                },
                onQAClicked = { subjectName ->
                    navController.navigate(Screen.QA.createRoute(subjectId, subjectName))
                }
            )
        }

        composable(
            route = Screen.QA.route,
            arguments = listOf(
                navArgument("subjectId") { type = NavType.StringType },
                navArgument("subjectName") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val subjectName = backStackEntry.arguments?.getString("subjectName") ?: "Subject"
            val vm = viewModel<QAViewModel>()
            QAScreen(viewModel = vm, subjectName = subjectName)
        }

        composable(
            route = Screen.ModuleList.route,
            arguments = listOf(navArgument("chapterId") { type = NavType.StringType })
        ) { backStackEntry ->
            val chapterId = backStackEntry.arguments?.getString("chapterId") ?: ""
            val vm = viewModel<ModuleListViewModel> {
                ModuleListViewModel(contentRepository, chapterId)
            }
            ModuleListScreen(
                viewModel = vm,
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
                ContentViewModel(contentRepository, moduleId)
            }
            ContentScreen(viewModel = vm)
        }
    }
}
