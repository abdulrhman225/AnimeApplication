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
import androidx.compose.ui.unit.min
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.animeapplication.ComposeFunctions.AnimeCard
import com.example.animeapplication.ComposeFunctions.AnimeCards
import com.example.animeapplication.ComposeFunctions.AnimeCategory
import com.example.animeapplication.ComposeFunctions.AnimeDependsOnAnimeName
import com.example.animeapplication.ComposeFunctions.SearchSection
import com.example.animeapplication.Model.API.AnimeContentAPI.AnimeContent.AnimeSearch
import com.example.animeapplication.Model.API.AnimeContentAPI.AnimeContentViewModel
import com.example.animeapplication.Model.API.AnimeGenresAPI.AnimeGenresContent
import com.example.animeapplication.Model.API.AnimeGenresAPI.AnimeGenresViewModel
import com.example.animeapplication.Screens.AnimeHomeScreen
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
                    AnimeHomeScreen()
                }
            }
        }
    }
}
