package com.burak.suggestify.domain.model.response

data class Track(
    val name : String,
    val playCount : Int,
    val mbid : String,
    val match : Double,
    val url : String,
    val duration : Int
)
