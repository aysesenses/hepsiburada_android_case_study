package com.aysesenses.hepsiburada_case_study.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aysesenses.hepsiburada_case_study.network.ItunesProperty

class DetailViewModelFactory(
    private val itunesProperty: ItunesProperty
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(itunesProperty) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
