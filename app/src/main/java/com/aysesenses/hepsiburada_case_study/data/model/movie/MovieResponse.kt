package com.aysesenses.hepsiburada_case_study.data.model.movie
import com.google.gson.annotations.SerializedName

class MovieResponse (
    @SerializedName("results")
    val movies: List<MovieProperty>
)