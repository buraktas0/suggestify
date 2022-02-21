package com.burak.suggestify.domain.model.request

data class TrackRequest(
    val artist : String,
    val autoCorrect : Int?,
    val limit : Int?,
    val mbid : String?,
    val track : String
)