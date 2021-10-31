package com.aysesenses.hepsiburada_case_study.data.model.ebook

import com.google.gson.annotations.SerializedName

data class EBookResponse (
    @SerializedName("results")
    val ebooks: List<EBookProperty> = emptyList()
    )