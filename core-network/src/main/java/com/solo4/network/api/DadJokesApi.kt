package com.solo4.network.api

import com.solo4.network.model.reponse.RandomJokePngResponse
import com.solo4.network.model.reponse.RandomJokeResponse
import retrofit2.http.GET

interface DadJokesApi {
    @GET("/random/joke")
    suspend fun getRandomJoke(): RandomJokeResponse

    @GET("/random/joke/png")
    suspend fun getRandomJokePng(): RandomJokePngResponse
}
