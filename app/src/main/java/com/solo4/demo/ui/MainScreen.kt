package com.solo4.demo.ui

import android.app.Activity
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.os.LocaleListCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.solo4.coreui.components.BottomBar
import com.solo4.coreui.components.BottomBarItem
import com.solo4.coreui.theme.DemoTheme
import com.solo4.demo.R
import com.solo4.demo.navigation.AppNavHost
import com.solo4.feature_i18n.Str
import com.solo4.feature_i18n.StringsSettings
import com.solo4.feature_i18n.str
import org.koin.compose.koinInject

@Composable
fun MainScreen(navController: NavHostController) {
    val context = LocalContext.current
    val qwe = koinInject<StringsSettings>()
    //val composer = currentComposer
    AppCompatDelegate.setApplicationLocales(LocaleListCompat.getDefault())

    Scaffold(
        bottomBar = {
            BottomBar {
                BottomBarItem(
                    label = { Text(text = str(Str.tab1)) },
                    selected = true,
                    alwaysShowLabel = true,
                    icon = { Image(painter = painterResource(id = R.drawable.ic_anchor), contentDescription = "Tab1") }
                ) {
                    navController.navigate("home")
                }
                BottomBarItem(
                    label = { Text(text = "Pictured Jokes") },
                    selected = true,
                    alwaysShowLabel = true,
                    icon = { Image(painter = painterResource(id = R.drawable.ic_circles), contentDescription = "Tab2") }
                ) {
                    navController.navigate("picture")
                }
                BottomBarItem(
                    label = { Text(text = stringResource(id = R.string.tab1)) },
                    selected = true,
                    alwaysShowLabel = true,
                    icon = { Image(painter = painterResource(id = R.drawable.ic_settings), contentDescription = "Tab2") }
                ) {
                    navController.navigate("settings")
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