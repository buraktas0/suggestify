package com.burak.suggestify.domain.model.response.similarArtists

import com.google.gson.annotations.SerializedName

data class SimilarArtistsResponse(
    @SerializedName("similarartists")
    val similarArtists: SimilarArtists
)