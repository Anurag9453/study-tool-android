package com.example.myapp.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object UserProfile : Screen("user_profile")
    object LanguageSelection : Screen("language_selection")
    object SectionSelection : Screen("section_selection")
    object ClassSelection : Screen("class_selection")
    object SubjectSelection : Screen("subject_selection/{classId}/{section}") {
        fun createRoute(classId: Int, section: String) = "subject_selection/$classId/$section"
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
    object QA : Screen("qa/{subjectId}/{subjectName}") {
        fun createRoute(subjectId: String, subjectName: String) = "qa/$subjectId/$subjectName"
    }
}
