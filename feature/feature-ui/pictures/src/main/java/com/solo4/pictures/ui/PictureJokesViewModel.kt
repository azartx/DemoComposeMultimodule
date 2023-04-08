package com.solo4.pictures.ui

import android.graphics.BitmapFactory
import android.util.Base64
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.asImageBitmap
import androidx.core.graphics.createBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solo4.core_data.repository.JokesRepository
import com.solo4.core_model.JokeAuthor
import com.solo4.core_model.JokePng
import com.solo4.coreui.common.Stateless
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PictureJokesViewModel(private val jokesRepository: JokesRepository) : ViewModel() {
    val placeholderImage = createBitmap(200, 200).asImageBitmap()

    val pictureJokesScreenState = mutableStateOf(
        PictureJokesState(
            currentJoke = JokePng(
                "0",
                "Loading",
                "Loading",
                "Loading",
                listOf(),
                JokeAuthor("", ""),
                true,
                0L,
                false,
                ""
            ),
            currentJokeBitmap = placeholderImage
        )
    )

    private val jokes = mutableListOf<JokePng>()

    init {
        requestJoke()
    }

    fun requestJoke() {
        viewModelScope.launch {
            pictureJokesScreenState.value =
                pictureJokesScreenState.value.copy(screenState = Stateless.Loading)
            val joke = jokesRepository.getRandomJokePng().getOrElse { e ->
                pictureJokesScreenState.value =
                    pictureJokesScreenState.value.copy(screenState = Stateless.Error(e))
                return@launch
            }
            jokes.add(joke)
            val bitmap = jokeToBitmap(joke)
            pictureJokesScreenState.value =
                pictureJokesScreenState.value.copy(
                    screenState = Stateless.Success,
                    currentJokeIndex = +1,
                    currentJoke = joke,
                    currentJokeBitmap = bitmap
                )
        }
    }

    private suspend fun jokeToBitmap(joke: JokePng) = withContext(Dispatchers.Default) {
        val imageBytes = Base64.decode(joke.imageBase64.substringAfter("data:image/png;base64,"), Base64.DEFAULT)
        BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size).asImageBitmap()
    }
}
