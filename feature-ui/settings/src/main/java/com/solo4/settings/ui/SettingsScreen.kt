package com.solo4.settings.ui

import android.app.Activity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.koin.androidx.compose.koinViewModel

@Composable
fun SettingsScreen(navController: NavHostController, viewModel: SettingsViewModel = koinViewModel()) {

    val isOpenLocalizationPicker = remember { mutableStateOf(false) }
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize().padding(20.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 48.dp)
                .clickable { isOpenLocalizationPicker.value = !isOpenLocalizationPicker.value },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text("Pick new language")
            DropdownMenu(
                expanded = isOpenLocalizationPicker.value,
                onDismissRequest = { isOpenLocalizationPicker.value = !isOpenLocalizationPicker.value }
            ) {
                DropdownMenuItem(
                    text = { Text("en") },
                    onClick = { viewModel.setNewLanguage("en", context as Activity) }
                )
                DropdownMenuItem(
                    text = { Text("ru") },
                    onClick = { viewModel.setNewLanguage("ru", context as Activity) }
                )
            }
        }
    }
}
