package com.aysesenses.hepsiburada_case_study.ui.main.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aysesenses.hepsiburada_case_study.data.model.movie.MovieProperty
import com.aysesenses.hepsiburada_case_study.ui.main.viewmodel.MovieViewModel

class MovieViewModelFactory (
    private val movieProperty: MovieProperty
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            return MovieViewModel(movieProperty) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}