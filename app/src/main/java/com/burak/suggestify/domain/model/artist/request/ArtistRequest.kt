package com.burak.suggestify.domain.model.artist.request

data class ArtistRequest (
    val artist : String,
    val autoCorrect : Int?,
    val limit : Int?,
    val mbid : String?
)
