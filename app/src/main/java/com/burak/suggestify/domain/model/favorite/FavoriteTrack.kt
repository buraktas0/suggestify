package com.burak.suggestify.domain.model.favorite

data class FavoriteTrack(
    val name: String,
    val artist: String,
    val image: String,
    val url: String,
    val time: Long
)