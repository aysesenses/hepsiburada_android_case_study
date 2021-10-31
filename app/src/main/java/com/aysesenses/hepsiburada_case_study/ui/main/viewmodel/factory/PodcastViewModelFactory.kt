package com.aysesenses.hepsiburada_case_study.ui.main.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aysesenses.hepsiburada_case_study.data.model.podcast.PodcastProperty
import com.aysesenses.hepsiburada_case_study.ui.main.viewmodel.PodcastViewModel

class PodcastViewModelFactory(
    private val podcastProperty: PodcastProperty
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PodcastViewModel::class.java)) {
            return PodcastViewModel(podcastProperty) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}