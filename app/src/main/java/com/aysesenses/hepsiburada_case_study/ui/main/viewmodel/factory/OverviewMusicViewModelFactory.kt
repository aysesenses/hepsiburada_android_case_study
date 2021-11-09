package com.aysesenses.hepsiburada_case_study.ui.main.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aysesenses.hepsiburada_case_study.data.model.music.MusicProperty
import com.aysesenses.hepsiburada_case_study.ui.main.viewmodel.OverviewMusicViewModel

class OverviewMusicViewModelFactory(
    private val musicProperty: MusicProperty
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OverviewMusicViewModel::class.java)) {
            return OverviewMusicViewModel(musicProperty) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
