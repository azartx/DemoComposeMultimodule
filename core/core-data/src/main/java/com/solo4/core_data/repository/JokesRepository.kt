package com.solo4.core_data.repository

import com.solo4.core_model.Joke
import com.solo4.core_model.JokePng

interface JokesRepository {
    suspend fun getRandomJoke(): Result<Joke>
    suspend fun getRandomJokePng(): Result<JokePng>
}
