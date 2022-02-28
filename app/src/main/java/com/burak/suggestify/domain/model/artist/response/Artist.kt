package com.burak.suggestify.domain.model.artist.response

import com.burak.suggestify.domain.model.common.Image

data class Artist(
    val name: String,
    val mbid: String,
    val match: Double,
    val url: String,
    val image: List<Image>,
    val streamable: Int
)

