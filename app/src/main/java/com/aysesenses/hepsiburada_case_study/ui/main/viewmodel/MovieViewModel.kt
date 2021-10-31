package com.aysesenses.hepsiburada_case_study.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aysesenses.hepsiburada_case_study.data.model.movie.MovieProperty

class MovieViewModel(movieProperty: MovieProperty): ViewModel(){

    private val _selectedMovieProperty = MutableLiveData<MovieProperty>()
    val selectedMovieProperty: LiveData<MovieProperty>
        get() = _selectedMovieProperty

    init {
        _selectedMovieProperty.value = movieProperty
    }
}