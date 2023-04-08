package com.solo4.settings.di

import com.solo4.feature_i18n.di.localizationModule
import com.solo4.settings.ui.SettingsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val settingsFeatureModule = module {
    includes(localizationModule)
    viewModel { SettingsViewModel(get()) }
}
