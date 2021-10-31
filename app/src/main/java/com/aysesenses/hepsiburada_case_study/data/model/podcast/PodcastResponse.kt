package com.aysesenses.hepsiburada_case_study.data.model.podcast
import com.google.gson.annotations.SerializedName

class PodcastResponse (
    @SerializedName("results")
    val podcasts: List<PodcastProperty>
)