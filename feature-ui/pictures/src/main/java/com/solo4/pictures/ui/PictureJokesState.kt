package com.solo4.pictures.ui

import android.graphics.Bitmap
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.ImageBitmap
import com.solo4.core_model.Joke
import com.solo4.core_model.JokePng
import com.solo4.coreui.common.ScreenState
import com.solo4.coreui.common.Stateless

@Stable
data class PictureJokesState(
    override val screenState: Stateless = Stateless.Loading,
    val currentJokeIndex: Int = 0,
    val currentJoke: JokePng,
    val currentJokeBitmap: ImageBitmap
) : ScreenState()
