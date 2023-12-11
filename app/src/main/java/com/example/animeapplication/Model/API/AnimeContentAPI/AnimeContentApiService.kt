package com.example.animeapplication.Model.API.AnimeContentAPI

import com.google.gson.JsonObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface AnimeContentApiService{
    @GET("anime")
    suspend fun getAnimeContent():JsonObject
}

object AnimeContentService{
    private val BASE_URL = "https://api.jikan.moe/v4/"

    private val retrofit:Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitService:AnimeContentApiService by lazy {
        retrofit.create(AnimeContentApiService::class.java)
    }

}