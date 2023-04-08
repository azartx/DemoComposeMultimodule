package com.solo4.network.intersceptors

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request().newBuilder()
                .addHeader("X-RapidAPI-Key", "0b6246b729mshfe1288748dc83bfp12960fjsnbae2545d7328")
                .addHeader("X-RapidAPI-Host", "dad-jokes.p.rapidapi.com")
                .build()
        )
    }
}