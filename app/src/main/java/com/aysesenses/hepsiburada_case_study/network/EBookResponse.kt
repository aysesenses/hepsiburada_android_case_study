package com.aysesenses.hepsiburada_case_study.network

import com.google.gson.annotations.SerializedName

data class EBookResponse (
    @SerializedName("results")
    val EBooks: List<EBookProperty>
    )