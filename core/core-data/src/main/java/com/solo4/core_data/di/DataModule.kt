package com.solo4.core_data.di

import com.solo4.core_data.repository.JokesRepository
import com.solo4.core_data.repository.impl.JokesRepositoryImpl
import com.solo4.network.di.networkModule
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    includes(networkModule)
    factory { JokesRepositoryImpl(get()) } bind JokesRepository::class
}
