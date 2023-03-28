package com.solo4.pictures.ui

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.asImageBitmap
import androidx.core.graphics.createBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solo4.core_data.repository.JokesRepository
import com.solo4.core_model.Joke
import com.solo4.core_model.JokeAuthor
import com.solo4.core_model.JokePng
import com.solo4.coreui.common.Stateless
import kotlinx.coroutines.launch

class PictureJokesViewModel(private val jokesRepository: JokesRepository) : ViewModel() {
    val placeholderImage = createBitmap(200, 200).asImageBitmap()

    val pictureJokesScreenState = mutableStateOf(
        PictureJokesState(currentJoke = JokePng("0", "Loading", "Loading", "Loading", listOf(), JokeAuthor("", ""), true, 0L, false, ""))
    )

    private val jokes = mutableListOf<JokePng>()

    init {
        requestJoke()
    }

    fun requestJoke() {
        viewModelScope.launch {
            pictureJokesScreenState.value = pictureJokesScreenState.value.copy(screenState = Stateless.Loading)
            val joke = jokesRepository.getRandomJokePng().getOrElse { e ->
                pictureJokesScreenState.value = pictureJokesScreenState.value.copy(screenState = Stateless.Error(e))
                return@launch
            }
            jokes.add(joke)
            pictureJokesScreenState.value =
                pictureJokesScreenState.value.copy(
                    screenState = Stateless.Success,
                    currentJokeIndex = +1,
                    currentJoke = joke
                )
        }
    }
}
