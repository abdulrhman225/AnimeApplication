package com.example.animeapplication.Model.API.AnimeContentAPI.AnimeContent


import com.google.gson.annotations.SerializedName

data class AnimeSearch(
    @SerializedName("aired")
    val aired: Aired,
    @SerializedName("airing")
    val airing: Boolean,
    @SerializedName("approved")
    val approved: Boolean,
    @SerializedName("background")
    val background: String,
    @SerializedName("broadcast")
    val broadcast: Broadcast,
    @SerializedName("demographics")
    val demographics: List<Demographics>,
    @SerializedName("duration")
    val duration: String,
    @SerializedName("episodes")
    val episodes: String,
    @SerializedName("explicit_genres")
    val explicitGenres: List<String>,
    @SerializedName("favorites")
    val favorites: String,
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("images")
    val images: Images,
    @SerializedName("licensors")
    val licensors: List<Licensor>,
    @SerializedName("mal_id")
    val malId: String,
    @SerializedName("members")
    val members: String,
    @SerializedName("popularity")
    val popularity: String,
    @SerializedName("producers")
    val producers: List<Producer>,
    @SerializedName("rank")
    val rank: String,
    @SerializedName("rating")
    val rating: String,
    @SerializedName("score")
    val score: String,
    @SerializedName("scored_by")
    val scoredBy: String,
    @SerializedName("season")
    val season: String,
    @SerializedName("source")
    val source: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("studios")
    val studios: List<Studio>,
    @SerializedName("synopsis")
    val synopsis: String,
    @SerializedName("themes")
    val themes: List<Theme>,
    @SerializedName("title")
    val title: String,
    @SerializedName("title_english")
    val titleEnglish: String,
    @SerializedName("title_japanese")
    val titleJapanese: String,
    @SerializedName("title_synonyms")
    val titleSynonyms: List<String>,
    @SerializedName("titles")
    val titles: List<Title>,
    @SerializedName("trailer")
    val trailer: Trailer,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("year")
    val year: String
)