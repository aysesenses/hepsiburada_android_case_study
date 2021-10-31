package com.aysesenses.hepsiburada_case_study.data.api


import com.aysesenses.hepsiburada_case_study.data.model.ebook.EBookResponse
import com.aysesenses.hepsiburada_case_study.data.model.app.AppResponse
import com.aysesenses.hepsiburada_case_study.data.model.movie.MovieResponse
import com.aysesenses.hepsiburada_case_study.data.model.music.MusicResponse
import com.aysesenses.hepsiburada_case_study.data.model.podcast.PodcastResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://itunes.apple.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface ItunesApiService {
    @GET("search?limit=20")
    fun search(@Query("term") term: String):
            Call<MusicResponse>

    @GET("search?entity=ebook&limit=20")
    fun searchEBook(@Query("term") term: String):
            Call<EBookResponse>

    @GET("search?entity=podcast&limit=20")
    fun searchPodcast(@Query("term") term: String):
            Call<PodcastResponse>

    @GET("search?entity=software&limit=20")
    fun searchApp(@Query("term") term: String):
            Call<AppResponse>

    @GET("search?entity=movie&limit=20")
    fun searchMovie(@Query("term") term: String):
            Call<MovieResponse>

    @GET("search?entity=musicVideo&limit=20")
    fun searchMusic(@Query("term") term: String):
            Call<MusicResponse>

}

object ItunesApi {
    val retrofitService: ItunesApiService by lazy {
        retrofit.create(ItunesApiService::class.java)
    }
}