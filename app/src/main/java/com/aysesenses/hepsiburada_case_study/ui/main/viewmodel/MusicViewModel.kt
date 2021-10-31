package com.aysesenses.hepsiburada_case_study.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aysesenses.hepsiburada_case_study.data.model.music.MusicProperty

class MusicViewModel (musicProperty: MusicProperty): ViewModel() {

    private val _selectedMusicProperty = MutableLiveData<MusicProperty>()
    val selectedMusicProperty: LiveData<MusicProperty>
        get() = _selectedMusicProperty

    init {
        _selectedMusicProperty.value = musicProperty
    }
}