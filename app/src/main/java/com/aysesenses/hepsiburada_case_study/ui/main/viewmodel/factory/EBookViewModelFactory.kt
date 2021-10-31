package com.aysesenses.hepsiburada_case_study.ui.main.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aysesenses.hepsiburada_case_study.data.model.ebook.EBookProperty
import com.aysesenses.hepsiburada_case_study.ui.main.viewmodel.EBookViewModel

class EBookViewModelFactory (
    private val eBookProperty: EBookProperty
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EBookViewModel::class.java)) {
            return EBookViewModel(eBookProperty) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}