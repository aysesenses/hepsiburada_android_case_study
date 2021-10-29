package com.aysesenses.hepsiburada_case_study.ebook

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aysesenses.hepsiburada_case_study.network.EBookProperty

class EBookViewModel(eBookProperty: EBookProperty): ViewModel() {
    private val _selectedBookProperty = MutableLiveData<EBookProperty>()

    val selectedEBookProperty: LiveData<EBookProperty>
        get() = _selectedBookProperty

    init {
        _selectedBookProperty.value = eBookProperty
    }
}