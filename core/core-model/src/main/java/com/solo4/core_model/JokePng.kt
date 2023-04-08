package com.solo4.core_model

data class JokePng(
    val id: String,
    val setup: String,
    val punchline: String,
    val type: String,
    val likes: List<Any>,
    val author: JokeAuthor,
    val isApproved: Boolean,
    val dateMillis: Long,
    val isNsfw: Boolean,
    val imageBase64: String
)
