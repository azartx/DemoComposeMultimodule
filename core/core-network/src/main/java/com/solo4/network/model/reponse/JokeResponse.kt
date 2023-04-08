package com.solo4.network.model.reponse

import com.google.gson.annotations.SerializedName

data class JokeResponse<T>(
    @SerializedName("success") val isSuccess: Boolean,
    val body: List<T?>
)

data class JokeResponsePng<T>(
    @SerializedName("success") val isSuccess: Boolean,
    val body: T?
)
