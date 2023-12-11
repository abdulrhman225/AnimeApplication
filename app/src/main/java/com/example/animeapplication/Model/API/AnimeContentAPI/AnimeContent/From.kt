package com.example.animeapplication.Model.API.AnimeContentAPI.AnimeContent


import com.google.gson.annotations.SerializedName

data class From(
    @SerializedName("day")
    val day: String,
    @SerializedName("month")
    val month: String,
    @SerializedName("year")
    val year: String
)