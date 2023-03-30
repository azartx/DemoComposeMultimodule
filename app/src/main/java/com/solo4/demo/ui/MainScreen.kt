package com.solo4.demo.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.solo4.coreui.components.BottomBar
import com.solo4.coreui.components.BottomBarItem
import com.solo4.coreui.theme.DemoTheme
import com.solo4.demo.R
import com.solo4.demo.navigation.AppNavHost
import com.solo4.demo.navigation.NavGraph
import com.solo4.feature_i18n.Str
import com.solo4.feature_i18n.str

@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomBar {
                BottomBarItem(
                    label = { Text(text = str(Str.bottomNavTab1)) },
                    selected = true,
                    alwaysShowLabel = true,
                    icon = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_anchor),
                            contentDescription = str(Str.bottomNavTab1)
                        )
                    }
                ) {
                    navController.navigate(NavGraph.HomeScreen.route)
                }
                BottomBarItem(
                    label = { Text(text = str(Str.bottomNavTab2)) },
                    selected = true,
                    alwaysShowLabel = true,
                    icon = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_circles),
                            contentDescription = str(Str.bottomNavTab2)
                        )
                    }
                ) {
                    navController.navigate(NavGraph.PicturesScreen.route)
                }
                BottomBarItem(
                    label = { Text(text = str(Str.bottomNavTab3)) },
                    selected = true,
                    alwaysShowLabel = true,
                    icon = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_settings),
                            contentDescription = str(Str.bottomNavTab3)
                        )
                    }
                ) {
                    navController.navigate(NavGraph.SettingsScreen.route)
                }
            }
        }
    ) { padding ->
        AppNavHost(
            modifier = Modifier.padding(padding),
            navController = navController
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DemoTheme {
        MainScreen(rememberNavController())
    }
}