package com.example.animeapplication.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.animeapplication.ComposeFunctions.AnimeCategory
import com.example.animeapplication.ComposeFunctions.AnimeDependsOnAnimeName
import com.example.animeapplication.ComposeFunctions.SearchSection

@Composable
fun AnimeHomeScreen(){
    var isSearchEmpty by remember { mutableStateOf(true) }
    var searchedAnime by remember { mutableStateOf("") }

    AnimeApplication(isSearchEmpty = isSearchEmpty,
        searchedAnime = searchedAnime ){changedText->
        isSearchEmpty = changedText.isEmpty()
        searchedAnime = changedText
    }

}

@Composable
fun AnimeApplication(
    isSearchEmpty:Boolean,
    searchedAnime:String,
    onValueChange : (changedText:String)-> Unit
) {
    Column {
        SearchSection {changedText ->
            onValueChange(changedText)
        }
        if (isSearchEmpty) {
            AnimeCategory()
        }else{
            AnimeDependsOnAnimeName(animeName = searchedAnime)
        }

    }

}