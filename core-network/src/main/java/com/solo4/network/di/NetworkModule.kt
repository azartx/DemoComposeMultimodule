package com.solo4.network.di

import com.google.gson.Gson
import com.solo4.network.intersceptors.HeaderInterceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { Gson() }
    single { provideOkHttpClient() }
    single { provideRetrofit(get(), get()) }
}

private fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(HeaderInterceptor())
        .build()
}

private fun provideRetrofit(gson: Gson, okHttp: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://dad-jokes.p.rapidapi.com")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttp)
        .build()
}
