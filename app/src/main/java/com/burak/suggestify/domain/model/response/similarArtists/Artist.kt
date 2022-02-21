package com.burak.suggestify.domain.model.response.similarArtists

data class Artist(
    val name : String,
    val mbid : String,
    val match : Double,
    val url : String,
    val image: List<Image>,
    val streamable: Int
)

