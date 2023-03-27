package com.solo4.home.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.solo4.coreui.theme.DemoTheme
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel = getViewModel()) {
    Box(Modifier.fillMaxSize()) {
        Text(modifier = Modifier.align(Alignment.Center), text = "Some text")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DemoTheme {
        HomeScreen(rememberNavController())
    }
}
