package com.aysesenses.hepsiburada_case_study.ui.main.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aysesenses.hepsiburada_case_study.data.model.app.AppProperty
import com.aysesenses.hepsiburada_case_study.ui.main.viewmodel.AppViewModel

class AppViewModelFactory (
    private val appProperty: AppProperty
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AppViewModel::class.java)) {
            return AppViewModel(appProperty) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}