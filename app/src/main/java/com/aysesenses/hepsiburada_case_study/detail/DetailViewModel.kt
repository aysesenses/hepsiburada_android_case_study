package com.aysesenses.hepsiburada_case_study.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aysesenses.hepsiburada_case_study.network.ItunesProperty

class DetailViewModel(itunesProperty: ItunesProperty) : ViewModel() {

    private val _selectedProperty = MutableLiveData<ItunesProperty>()

    val selectedProperty: LiveData<ItunesProperty>
        get() = _selectedProperty

    init {
        _selectedProperty.value = itunesProperty
    }

}