package com.example.animeapplication.ComposeFunctions

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.animeapplication.Model.API.AnimeContentAPI.AnimeContent.AnimeSearch
import com.example.animeapplication.Model.API.AnimeContentAPI.AnimeContentViewModel

@Composable
fun AnimeDependsOnAnimeName(animeName:String){
    val animeContentViewModel: AnimeContentViewModel = viewModel(AnimeContentViewModel::class.java)
    animeContentViewModel.getAllAnimeDependOnAnimeName(animeName)
    val animeContent by animeContentViewModel.mutable.collectAsState()
    AnimeByAnimeName(animeName = animeName, animeContent = animeContent )
}

@Composable
fun AnimeByAnimeName(
    animeName: String,
    animeContent: List<AnimeSearch>
) {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = (128.dp)),
        Modifier.fillMaxSize()
    ) {
        items(animeContent) { animeContent: AnimeSearch ->
            AnimeCard(animeContent.title, animeContent.images.jpg.imageUrl)
        }
    }
}