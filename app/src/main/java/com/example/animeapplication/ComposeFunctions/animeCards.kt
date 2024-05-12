package com.example.animeapplication.ComposeFunctions

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.animeapplication.Model.API.AnimeContentAPI.AnimeContent.AnimeSearch
import com.example.animeapplication.Model.API.AnimeContentAPI.AnimeContentViewModel

@Composable
fun AnimeCards(
    animeGenres: String = "Action"
) {
    val animeContentViewModel: AnimeContentViewModel = viewModel(AnimeContentViewModel::class.java)
    animeContentViewModel.getAllAnimeDependOnCategory(animeGenres)
    val animeContent by animeContentViewModel.mutable.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        Modifier.fillMaxSize()
    ) {
        items(animeContent) { animeContent: AnimeSearch ->
            AnimeCard(animeContent.title, animeContent.images.jpg.imageUrl)
        }
    }
}