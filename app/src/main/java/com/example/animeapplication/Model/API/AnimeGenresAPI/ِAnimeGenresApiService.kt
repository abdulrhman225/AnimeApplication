package com.example.animeapplication.Model.API.AnimeGenresAPI

import com.google.gson.JsonObject
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


interface AnimeGenresApiService {
    @GET("anime")
   suspend fun getAnimeGenres():JsonObject
}


object AnimeGenresService {

    private val BASE_URL:String = "https://api.jikan.moe/v4/genres/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val retrofitService: AnimeGenresApiService by lazy {
        retrofit.create(AnimeGenresApiService::class.java)
    }
}

