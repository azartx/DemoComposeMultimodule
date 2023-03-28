package com.solo4.home.di

import com.solo4.core_data.di.dataModule
import com.solo4.home.ui.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    includes(dataModule)
    viewModel { HomeViewModel(get()) }
}