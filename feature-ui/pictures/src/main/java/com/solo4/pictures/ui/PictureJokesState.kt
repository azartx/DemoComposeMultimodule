package com.solo4.pictures.ui

import androidx.compose.runtime.Stable
import com.solo4.core_model.Joke
import com.solo4.core_model.JokePng
import com.solo4.coreui.common.ScreenState
import com.solo4.coreui.common.Stateless

@Stable
data class PictureJokesState(
    override val screenState: Stateless = Stateless.Loading,
    val currentJokeIndex: Int = 0,
    val currentJoke: JokePng
) : ScreenState()
