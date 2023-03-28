package com.solo4.core_data.repository.impl

import com.solo4.common.transform
import com.solo4.core_data.repository.JokesRepository
import com.solo4.core_model.Joke
import com.solo4.network.api.DadJokesApi
import com.solo4.network.model.reponse.RandomJokePngResponse
import com.solo4.network.model.reponse.RandomJokeResponse

class JokesRepositoryImpl(private val jokesApi: DadJokesApi) : JokesRepository {
    override suspend fun getRandomJoke(): Result<Joke> {
        return runCatching {
            jokesApi.getRandomJoke().body
                .lastOrNull()
                ?.transform { Joke(it.id, it.setup, it.punchline, it.type) }
                ?: throw java.lang.Exception()
        }
    }

    override suspend fun getRandomJokePng(): Result<RandomJokePngResponse> {
        //return runCatching { jokesApi.getRandomJokePng() }
        return throw java.lang.Exception()
    }
}