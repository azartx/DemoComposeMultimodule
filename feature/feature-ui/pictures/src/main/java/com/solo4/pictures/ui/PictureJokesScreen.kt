package com.solo4.pictures.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.koinViewModel

@Composable
fun PictureJokesScreen(navController: NavHostController, viewModel: PictureJokesViewModel = koinViewModel()) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(bitmap = viewModel.pictureJokesScreenState.value.currentJokeBitmap, contentDescription = "")
        Button(onClick = { viewModel.requestJoke() }) {
            Text(text = "Next image")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PictureJokesScreenPreview() {
    MaterialTheme {
        PictureJokesScreen(rememberNavController())
    }
}
