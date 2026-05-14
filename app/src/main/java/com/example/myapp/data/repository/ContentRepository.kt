package com.example.myapp.data.repository

import com.example.myapp.data.model.*

interface ContentRepository {
    fun getClasses(): List<SchoolClass>
    fun getSubjects(section: String): List<Subject>
    fun getChapters(classId: Int, subjectId: String): List<Chapter>
    fun getModules(chapterId: String): List<Module>
    fun getModuleTitle(moduleId: String): String
    fun getContentBlocks(moduleId: String): List<ContentBlock>
    fun getQuestions(moduleId: String): List<Question>
}
