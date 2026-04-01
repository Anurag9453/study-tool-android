package com.example.myapp.ui.modulelist

import androidx.lifecycle.ViewModel
import com.example.myapp.data.model.Module
import com.example.myapp.data.repository.ContentRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ModuleListViewModel(
    contentRepository: ContentRepository,
    chapterId: String
) : ViewModel() {

    private val _modules = MutableStateFlow(contentRepository.getModules(chapterId))
    val modules: StateFlow<List<Module>> = _modules
}
