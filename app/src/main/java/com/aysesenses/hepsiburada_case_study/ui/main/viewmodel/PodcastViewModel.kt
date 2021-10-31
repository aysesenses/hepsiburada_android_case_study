package com.aysesenses.hepsiburada_case_study.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aysesenses.hepsiburada_case_study.data.model.podcast.PodcastProperty

class PodcastViewModel(podcastProperty: PodcastProperty): ViewModel(){

    private val _selectedPodcastProperty = MutableLiveData<PodcastProperty>()
    val selectedPodcastProperty: LiveData<PodcastProperty>
        get() = _selectedPodcastProperty

    init {
        _selectedPodcastProperty.value = podcastProperty
    }
}