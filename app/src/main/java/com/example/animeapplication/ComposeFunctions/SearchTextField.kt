package com.example.animeapplication.ComposeFunctions

import android.content.res.Configuration.UI_MODE_NIGHT_MASK
import android.graphics.Color
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import com.example.animeapplication.R
import com.example.animeapplication.ui.theme.White


@Composable
fun SearchSection(
    onValueChange: (changedText: String) -> Unit
){
    var animeName by remember { mutableStateOf("") }
    SearchView(animeName= animeName){
        animeName = it
        onValueChange(it)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchView(
    animeName: String,
    onValueChange: (changedText: String) -> Unit
) {

    TextField(
        value = animeName,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp, horizontal = 8.dp)
            .height(58.dp)
            .clip(RoundedCornerShape(16.dp)),

        label = {
                Text(text = "Search")
        },

        colors = TextFieldDefaults.textFieldColors(
            containerColor = MaterialTheme.colorScheme.surface,
            disabledIndicatorColor = White,
            focusedIndicatorColor = White,
            unfocusedIndicatorColor = White,
            errorIndicatorColor = White
        ),
        leadingIcon = {
            Icon(
                imageVector =
                ImageVector.vectorResource(id = R.drawable.baseline_search_24),
                contentDescription = null
            )
        },

        onValueChange = {
            onValueChange(it)
        })
}
@Preview(showSystemUi = false)
@Composable
fun SearchTextFieldPreview(){
    SearchSection(){}
}