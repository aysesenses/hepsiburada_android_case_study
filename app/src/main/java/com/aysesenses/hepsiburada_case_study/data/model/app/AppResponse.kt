package com.aysesenses.hepsiburada_case_study.data.model.app
import com.google.gson.annotations.SerializedName

class AppResponse (
    @SerializedName("results")
    val apps: List<AppProperty>
)