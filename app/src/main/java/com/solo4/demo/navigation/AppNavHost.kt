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
    startDestination: String = NavGraph.HomeScreen.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        composable(NavGraph.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(NavGraph.PicturesScreen.route) {
            PictureJokesScreen(navController)
        }
        composable(NavGraph.SettingsScreen.route) {
            SettingsScreen(navController)
        }
    }
}
