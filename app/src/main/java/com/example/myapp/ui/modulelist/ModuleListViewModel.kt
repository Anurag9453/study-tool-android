package com.example.myapp.ui.modulelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapp.data.model.Module
import com.example.myapp.data.repository.ContentRepository
import com.example.myapp.data.scoring.ModuleScore
import com.example.myapp.data.scoring.ScoringRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class ModuleListViewModel(
    contentRepository: ContentRepository,
    chapterId: String,
    scoringRepository: ScoringRepository
) : ViewModel() {

    private val _modules = MutableStateFlow(contentRepository.getModules(chapterId))
    val modules: StateFlow<List<Module>> = _modules

    val moduleScores: StateFlow<Map<String, ModuleScore>> =
        scoringRepository.getPointsForAllModules()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyMap())
}
