package com.solo4.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.solo4.coreui.common.Stateless
import com.solo4.coreui.theme.DemoTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel = koinViewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = viewModel.homeScreenState.value.currentJoke.setup
        )
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = viewModel.homeScreenState.value.currentJoke.punchline
        )
        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 40.dp),
            onClick = viewModel::requestJoke
        ) {
            Text(text = "Next Joke")
        }
        if (viewModel.homeScreenState.value.screenState is Stateless.Error) {
            Snackbar {
                Text(text = "Error, something went wrong.")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    DemoTheme {
        HomeScreen(rememberNavController())
    }
}
