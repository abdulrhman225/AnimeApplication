package com.example.animeapplication.ComposeFunctions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.animeapplication.Model.API.AnimeContentAPI.AnimeContent.AnimeSearch
import com.example.animeapplication.Model.API.AnimeContentAPI.AnimeContentViewModel
import com.example.animeapplication.R

@Composable
fun AnimeCard(
    animeName: String = "One Piece",
    animeImage: String = ""
) {
    val animeImagePainter = rememberAsyncImagePainter(model = animeImage)

    Surface(modifier = Modifier.padding(8.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(color = colorResource(id = R.color.Gray))
                .width(150.dp)
                .height(270.dp)
        ) {
            Image(
                painter = animeImagePainter,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(220.dp)
                    .padding(top = 8.dp)
                    .clip(MaterialTheme.shapes.extraLarge),
                contentDescription = null
            )

            Text(
                modifier = Modifier.padding(4.dp),
                text = animeName,
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.white)
            )
        }
    }
}