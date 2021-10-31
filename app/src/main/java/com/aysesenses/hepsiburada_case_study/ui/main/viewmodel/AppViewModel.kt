package com.aysesenses.hepsiburada_case_study.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aysesenses.hepsiburada_case_study.data.model.app.AppProperty

class AppViewModel (appProperty: AppProperty): ViewModel(){

    private val _selectedAppProperty = MutableLiveData<AppProperty>()
    val selectedAppProperty: LiveData<AppProperty>
        get() = _selectedAppProperty

    init {
        _selectedAppProperty.value = appProperty
    }
}