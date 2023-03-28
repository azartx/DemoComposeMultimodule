package com.solo4.home.ui

import androidx.compose.runtime.Stable
import com.solo4.core_model.Joke
import com.solo4.coreui.common.ScreenState
import com.solo4.coreui.common.Stateless

@Stable
data class HomeState(
    override val screenState: Stateless = Stateless.Loading,
    val currentJokeIndex: Int = 0,
    val currentJoke: Joke
) : ScreenState()
