package com.example.animeapplication.Model.API.AnimeContentAPI.AnimeContent


import com.google.gson.annotations.SerializedName

data class Studio(
    @SerializedName("mal_id")
    val malId: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)