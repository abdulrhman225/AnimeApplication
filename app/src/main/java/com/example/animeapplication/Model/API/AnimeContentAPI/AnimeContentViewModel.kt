package com.example.animeapplication.Model.API.AnimeContentAPI

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animeapplication.Model.API.AnimeContentAPI.AnimeContent.AnimeSearch
import com.example.animeapplication.Model.API.AnimeContentAPI.AnimeContent.Genre
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AnimeContentViewModel : ViewModel() {
    private val _mutable = MutableStateFlow(emptyList<AnimeSearch>())
    val mutable: StateFlow<List<AnimeSearch>> = _mutable


    fun getAllAnimeDependOnCategory(category :String) {
        viewModelScope.launch {
            val animeContent = AnimeContentService.retrofitService.getAnimeContent()
            _mutable.value = convertFRomJsonToList(animeContent , category)
        }


    }



    private fun convertFRomJsonToList(json: JsonObject , category:String): List<AnimeSearch> {
        val animeContent: ArrayList<AnimeSearch> = ArrayList()

        val jsonArray: JsonArray = json.getAsJsonArray("data")

        for (i in 0 until jsonArray.size()) {

            val animeSearch: AnimeSearch =
                Gson().fromJson(jsonArray.get(i), AnimeSearch::class.java)

            if (filterAnimeToCategory(category , animeSearch)) {
                animeContent.add(animeSearch)
            }
        }
        return animeContent
    }

    private fun filterAnimeToCategory(category : String , anime : AnimeSearch) : Boolean{
        val genres :List<Genre> = anime.genres
        for (genre :Genre in genres){
            if (genre.name == category){
                return true
            }
        }
        return false
    }

    fun getAllAnimeDependOnAnimeName(animeName :String) {
        viewModelScope.launch {
            val animeContent = AnimeContentService.retrofitService.getAnimeContent()
            _mutable.value = convertFRomJsonToListAndFilterDependOnAnimeName(animeContent , animeName)
        }


    }

    private fun convertFRomJsonToListAndFilterDependOnAnimeName(json: JsonObject , animeName:String): List<AnimeSearch> {
        val animeContent: ArrayList<AnimeSearch> = ArrayList()

        val jsonArray: JsonArray = json.getAsJsonArray("data")

        for (i in 0 until jsonArray.size()) {

            val animeSearch: AnimeSearch =
                Gson().fromJson(jsonArray.get(i), AnimeSearch::class.java)

            if (filterAnimeToAnimeName(animeName , animeSearch)) {
                animeContent.add(animeSearch)
            }
        }
        return animeContent
    }

    private fun filterAnimeToAnimeName(animeName : String , anime : AnimeSearch) : Boolean{
        return anime.title.contains(animeName)
    }


}