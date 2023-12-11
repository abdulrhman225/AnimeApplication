package com.example.animeapplication.Model.API.AnimeGenresAPI

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AnimeGenresViewModel : ViewModel() {
    private val _mutable = MutableStateFlow(emptyList<AnimeGenresContent>())
    val mutable: StateFlow<List<AnimeGenresContent>> = _mutable


    init {
        viewModelScope.launch {
            val animeGenres = AnimeGenresService.retrofitService.getAnimeGenres()
            _mutable.value = convertFromJsonToList(animeGenres)
        }
    }

    private fun convertFromJsonToList(json: JsonObject): List<AnimeGenresContent> {
        val animeGenres: ArrayList<AnimeGenresContent> = ArrayList()

        val jsonArray: JsonArray = json.getAsJsonArray("data")

        for (i in 0 until jsonArray.size()) {
                val genres: AnimeGenresContent =
                    Gson().fromJson(jsonArray.get(i), AnimeGenresContent::class.java)

                if (!isItBadGenres(genres.name)) {
                    animeGenres.add(genres)
                }
        }
        return animeGenres
    }

    private fun isItBadGenres(genre: String): Boolean {
        if (genre == "Hentai" || genre == "Ecchi" ||
            genre == "Erotica" || genre == "Adult Cast" ||
            genre == "Girls Love" || genre == "Boys Love"
        ) {
            return true
        }
        return false
    }
}