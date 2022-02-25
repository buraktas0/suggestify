package com.burak.suggestify.domain.model.artist.response

import com.google.gson.annotations.SerializedName

data class SimilarArtistsResponse(
    @SerializedName("similarartists")
    val similarArtists: SimilarArtists
)