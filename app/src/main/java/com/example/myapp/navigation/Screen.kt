package com.example.myapp.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object UserProfile : Screen("user_profile")
    object LanguageSelection : Screen("language_selection")
    object ClassSelection : Screen("class_selection")
    object SubjectSelection : Screen("subject_selection/{classId}") {
        fun createRoute(classId: Int) = "subject_selection/$classId"
    }
    object ChapterList : Screen("chapter_list/{classId}/{subjectId}") {
        fun createRoute(classId: Int, subjectId: String) = "chapter_list/$classId/$subjectId"
    }
    object ModuleList : Screen("module_list/{chapterId}") {
        fun createRoute(chapterId: String) = "module_list/$chapterId"
    }
    object Content : Screen("content/{moduleId}") {
        fun createRoute(moduleId: String) = "content/$moduleId"
    }
    object Leaderboard : Screen("leaderboard")
}
