package com.aysesenses.hepsiburada_case_study.ui.main.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aysesenses.hepsiburada_case_study.data.model.music.MusicProperty
import com.aysesenses.hepsiburada_case_study.ui.main.viewmodel.MusicViewModel

class MusicViewModelFactory (
    private val musicProperty: MusicProperty
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MusicViewModel::class.java)) {
            return MusicViewModel(musicProperty) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}