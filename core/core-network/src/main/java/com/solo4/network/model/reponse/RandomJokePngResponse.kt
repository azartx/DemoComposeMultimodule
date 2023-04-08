package com.solo4.network.model.reponse

import com.google.gson.annotations.SerializedName
import com.solo4.core_model.JokeAuthor

data class RandomJokePngResponse(
    @SerializedName("_id") val id: String,
    @SerializedName("setup") val setup: String,
    @SerializedName("punchline") val punchline: String,
    @SerializedName("type") val type: String,
    @SerializedName("likes") val likes: List<Any>,
    @SerializedName("author") val author: JokeAuthor,
    @SerializedName("approved") val isApproved: Boolean,
    @SerializedName("date") val dateMillis: Long,
    @SerializedName("NSFW") val isNsfw: Boolean,
    @SerializedName("image") val imageBase64: String
)
