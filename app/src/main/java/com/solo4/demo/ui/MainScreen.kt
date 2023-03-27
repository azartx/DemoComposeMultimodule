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

@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomBar {
                BottomBarItem(
                    label = { Text(text = "Tab1") },
                    selected = true,
                    alwaysShowLabel = true,
                    icon = { Image(painter = painterResource(id = R.drawable.ic_anchor), contentDescription = "Tab1") }
                ) {
                    // todo on click
                }
                BottomBarItem(
                    label = { Text(text = "Tab2") },
                    selected = true,
                    alwaysShowLabel = true,
                    icon = { Image(painter = painterResource(id = R.drawable.ic_circles), contentDescription = "Tab2") }
                ) {
                    // todo on click
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