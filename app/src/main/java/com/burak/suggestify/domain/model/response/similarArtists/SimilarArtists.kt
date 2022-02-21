package com.burak.suggestify.domain.model.response.similarArtists

import com.google.gson.annotations.SerializedName

data class SimilarArtists(
    @SerializedName("artist")
    val artistList: List<Artist>
)