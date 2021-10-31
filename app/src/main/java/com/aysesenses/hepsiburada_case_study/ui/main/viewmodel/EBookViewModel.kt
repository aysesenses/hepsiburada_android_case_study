package com.aysesenses.hepsiburada_case_study.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aysesenses.hepsiburada_case_study.data.model.ebook.EBookProperty

class EBookViewModel(eBookProperty: EBookProperty): ViewModel() {
    private val _selectedBookProperty = MutableLiveData<EBookProperty>()

    val selectedEBookProperty: LiveData<EBookProperty>
        get() = _selectedBookProperty

    init {
        _selectedBookProperty.value = eBookProperty
    }
}