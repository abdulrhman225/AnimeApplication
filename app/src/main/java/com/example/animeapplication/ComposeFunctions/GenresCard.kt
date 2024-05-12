package com.example.animeapplication.ComposeFunctions

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.animeapplication.Model.API.AnimeGenresAPI.AnimeGenresContent
import com.example.animeapplication.Model.API.AnimeGenresAPI.AnimeGenresViewModel
import com.example.animeapplication.R


@Composable
fun AnimeSection(
    genres: String,
    onClick: () -> Unit
) {


    Card(
        modifier = Modifier.padding(5.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(R.color.white))
    ) {
        Text(
            text = genres,
            modifier = Modifier
                .padding(horizontal = 5.dp, vertical = 2.dp)
                .clickable {
                    onClick()
                },
            style = MaterialTheme.typography.bodyLarge,
            color = colorResource(id = R.color.Gray)
        )
    }
}

@Preview(showSystemUi = false)
@Composable
fun AnimeSectionPreview(){
    AnimeSection(genres = "Action") {

    }
}