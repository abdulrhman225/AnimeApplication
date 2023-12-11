@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.animeapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.currentCompositionErrors
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.animeapplication.Model.API.AnimeContentAPI.AnimeContent.AnimeSearch
import com.example.animeapplication.Model.API.AnimeContentAPI.AnimeContentViewModel
import com.example.animeapplication.Model.API.AnimeGenresAPI.AnimeGenresContent
import com.example.animeapplication.Model.API.AnimeGenresAPI.AnimeGenresViewModel
import com.example.animeapplication.ui.theme.AnimeApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AnimeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = colorResource(id = R.color.Gray),
                    modifier = Modifier.background(color = colorResource(id = R.color.Gray))
                ) {
                    AnimeApplication()
                }
            }
        }
    }
}

@Composable
fun AnimeApplication() {
    var isSearchEmpty by remember { mutableStateOf(true) }
    var searchedAnime by remember { mutableStateOf("") }

    Column {
        SearchSection {
            isSearchEmpty = it.isEmpty()
            searchedAnime = it
        }
        if (isSearchEmpty) {
            AnimeCategory()
        }else{
            AnimeCardsDependsOnAnimeName(animeName = searchedAnime)
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchSection(
    onValueChange: (changedText: String) -> Unit
) {
    var animeName by remember { mutableStateOf("") }

    TextField(
        value = animeName,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp, horizontal = 8.dp)
            .height(58.dp),

        placeholder = {
            Text(text = "Search")
        },

        colors = TextFieldDefaults.textFieldColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        leadingIcon = {
            Icon(
                imageVector =
                ImageVector.vectorResource(id = R.drawable.baseline_search_24),
                contentDescription = null
            )
        },

        onValueChange = {
            animeName = it
            onValueChange(it)
        })
}


@Composable
fun AnimeSection(
    genres: String,
    onClick: () -> Unit
) {


    Card(
        modifier = Modifier.padding(2.dp),
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

@Composable
fun AnimeCategory() {
    val animeGenresViewModel = viewModel(AnimeGenresViewModel::class.java)
    val animeGenres by animeGenresViewModel.mutable.collectAsState()

    var currentGenre by remember { mutableStateOf("Action") }

    Column {
        LazyRow(modifier = Modifier.padding(8.dp)) {
            items(animeGenres) { animeGenres: AnimeGenresContent ->
                AnimeSection(animeGenres.name) {
                    currentGenre = animeGenres.name
                }
            }
        }
        AnimeCards(currentGenre)
    }
}


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

@Composable
fun AnimeCardsDependsOnAnimeName(
    animeName: String
) {
    val animeContentViewModel: AnimeContentViewModel = viewModel(AnimeContentViewModel::class.java)
    animeContentViewModel.getAllAnimeDependOnAnimeName(animeName)
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

@Preview
@Composable
fun SearchSectionPreview() {
    SearchSection(){}
}

@Preview
@Composable
fun AnimeCategoryPreview() {
    AnimeCategory()
}

@Preview
@Composable
fun AnimeCardPreview() {
    AnimeCard()
}

@Preview
@Composable
fun AnimeCardsPreview() {
    AnimeCards()
}