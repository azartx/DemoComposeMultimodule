package com.solo4.demo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.solo4.home.ui.HomeScreen
import com.solo4.pictures.ui.PictureJokesScreen
import com.solo4.settings.ui.SettingsScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = "home"
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        composable("home") {
            HomeScreen(navController)
        }
        composable("picture") {
            PictureJokesScreen(navController)
        }
        composable("settings") {
            SettingsScreen(navController)
        }
    }
}
