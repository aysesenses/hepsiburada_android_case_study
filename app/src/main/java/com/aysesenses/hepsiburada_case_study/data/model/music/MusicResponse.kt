package com.aysesenses.hepsiburada_case_study.data.model.music
import com.google.gson.annotations.SerializedName

class MusicResponse (
    @SerializedName("results")
    val musics: List<MusicProperty>
)