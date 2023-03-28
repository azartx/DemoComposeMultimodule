package com.solo4.home.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solo4.core_data.repository.JokesRepository
import com.solo4.core_model.Joke
import com.solo4.coreui.common.Stateless
import kotlinx.coroutines.launch

class HomeViewModel(private val jokesRepository: JokesRepository) : ViewModel() {

    val homeScreenState = mutableStateOf(
        HomeState(currentJoke = Joke("0", "Loading", "Loading", "Loading"))
    )

    private val jokes = mutableListOf<Joke>()

    init {
        requestJoke()
    }

    fun requestJoke() {
        viewModelScope.launch {
            homeScreenState.value = homeScreenState.value.copy(screenState = Stateless.Loading)
            val joke = jokesRepository.getRandomJoke().getOrElse { e ->
                homeScreenState.value = homeScreenState.value.copy(screenState = Stateless.Error(e))
                return@launch
            }
            jokes.add(joke)
            homeScreenState.value =
                homeScreenState.value.copy(
                    screenState = Stateless.Success,
                    currentJokeIndex = +1,
                    currentJoke = joke
                )
        }
    }

    fun getJokeByIndex(index: Int) = jokes.getOrNull(index)
}
