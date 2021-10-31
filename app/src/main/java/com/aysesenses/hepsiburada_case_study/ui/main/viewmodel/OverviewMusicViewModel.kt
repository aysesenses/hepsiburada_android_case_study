package com.aysesenses.hepsiburada_case_study.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aysesenses.hepsiburada_case_study.data.model.music.MusicProperty

class OverviewMusicViewModel(musicProperty: MusicProperty) : ViewModel() {

    private val _selectedOverviewMusicProperty = MutableLiveData<MusicProperty>()

    val selectedOverviewMusicProperty: LiveData<MusicProperty>
        get() = _selectedOverviewMusicProperty

    init {
        _selectedOverviewMusicProperty.value = musicProperty
    }

}