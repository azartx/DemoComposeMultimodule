package com.solo4.pictures.di

import com.solo4.core_data.di.dataModule
import com.solo4.pictures.ui.PictureJokesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val picturesFeatureModule = module {
    includes(dataModule)
    viewModel { PictureJokesViewModel(get()) }
}
