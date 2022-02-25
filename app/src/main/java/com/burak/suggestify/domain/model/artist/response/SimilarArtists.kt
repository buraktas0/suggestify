package com.burak.suggestify.domain.model.artist.response

import com.google.gson.annotations.SerializedName

data class SimilarArtists(
    @SerializedName("artist")
    val artistList: List<Artist>
)