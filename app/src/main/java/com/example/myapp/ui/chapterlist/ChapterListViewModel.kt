package com.example.myapp.ui.chapterlist

import androidx.lifecycle.ViewModel
import com.example.myapp.data.model.Chapter
import com.example.myapp.data.repository.ContentRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ChapterListViewModel(
    contentRepository: ContentRepository,
    classId: Int,
    subjectId: String
) : ViewModel() {

    private val _chapters = MutableStateFlow(contentRepository.getChapters(classId, subjectId))
    val chapters: StateFlow<List<Chapter>> = _chapters
}
