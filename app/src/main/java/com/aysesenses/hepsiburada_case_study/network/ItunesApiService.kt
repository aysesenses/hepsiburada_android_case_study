package com.aysesenses.hepsiburada_case_study.network


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
    @GET("search")
    fun search(@Query("term") term: String):
            Call<SearchResponse>

    @GET("search?entity=ebook")
    fun searchEBook(@Query("term") term: String):
            Call<EBookResponse>
}

object ItunesApi {
    val retrofitService: ItunesApiService by lazy {
        retrofit.create(ItunesApiService::class.java)
    }
}