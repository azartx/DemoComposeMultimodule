package com.solo4.network.model.reponse

import com.google.gson.annotations.SerializedName

data class RandomJokeResponse(
    @SerializedName("_id") val id: String,
    @SerializedName("setup") val setup: String,
    @SerializedName("punchline") val punchline: String,
    @SerializedName("type") val type: String
)
