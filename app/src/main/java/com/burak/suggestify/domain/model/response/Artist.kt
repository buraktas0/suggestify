package com.burak.suggestify.domain.model.response

data class Artist(
    val name : String,
    val mbid : String,
    val match : Double,
    val url : String,
    val image: List<Image>,
    val streamable: Int
)
