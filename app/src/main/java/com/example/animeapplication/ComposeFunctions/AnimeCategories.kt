package com.example.animeapplication.ComposeFunctions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.animeapplication.Model.API.AnimeContentAPI.AnimeContentViewModel
import com.example.animeapplication.Model.API.AnimeGenresAPI.AnimeGenresContent
import com.example.animeapplication.Model.API.AnimeGenresAPI.AnimeGenresViewModel

@Composable
fun AnimeCategory(){
    val animeGenresViewModel = viewModel(AnimeGenresViewModel::class.java)
    val animeGenres by animeGenresViewModel.mutable.collectAsState()
    var currentGenre by remember { mutableStateOf("Action") }
    Anime(currentGenre = currentGenre , animeGenres){ genre ->
        currentGenre = genre

    }
}

@Composable
fun Anime(
    currentGenre: String,
    genreContent: List<AnimeGenresContent>,
    onClick: (name:String)-> Unit
) {


    Column {
        LazyRow(
            contentPadding = PaddingValues(5.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items(genreContent) { animeGenres: AnimeGenresContent ->
                AnimeSection(animeGenres.name) {
                    onClick(animeGenres.name)
                }
            }
        }
        AnimeCards(currentGenre)
    }
}

@Composable
@Preview(showSystemUi = false)
fun AnimeCategoriesPreview(){
    AnimeCategory()
}