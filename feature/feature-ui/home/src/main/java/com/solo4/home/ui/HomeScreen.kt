package com.solo4.home.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.solo4.coreui.common.Stateless
import com.solo4.coreui.theme.ApplicationTheme
import com.solo4.feature_i18n.Str
import com.solo4.feature_i18n.str
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel = koinViewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 48.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = viewModel.homeScreenState.value.currentJoke.setup,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(28.dp))
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = viewModel.homeScreenState.value.currentJoke.punchline,
            textAlign = TextAlign.Center
        )
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                modifier = Modifier.align(Alignment.Bottom),
                onClick = viewModel::requestJoke
            ) {
                Text(text = str(Str.buttonTextNextJoke))
            }
        }

        if (viewModel.homeScreenState.value.screenState is Stateless.Error) {
            Snackbar {
                Text(text = str(Str.errorSmthWentWrong))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ApplicationTheme {
        HomeScreen(rememberNavController())
    }
}
