package com.solo4.core_data.repository.impl

import com.solo4.common.transform
import com.solo4.core_data.repository.JokesRepository
import com.solo4.core_model.Joke
import com.solo4.core_model.JokePng
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

    override suspend fun getRandomJokePng(): Result<JokePng> {
        return runCatching {
            jokesApi.getRandomJokePng().body
                ?.transform {
                    JokePng(
                        it.id,
                        it.setup,
                        it.punchline,
                        it.type,
                        it.likes,
                        it.author,
                        it.isApproved,
                        it.dateMillis,
                        it.isNsfw,
                        it.imageBase64
                    )
                }
                ?: throw java.lang.Exception()
        }
    }
}