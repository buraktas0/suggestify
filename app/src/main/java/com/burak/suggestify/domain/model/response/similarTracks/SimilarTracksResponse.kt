package com.burak.suggestify.domain.model.response.similarTracks

import com.google.gson.annotations.SerializedName

data class SimilarTracksResponse(
    @SerializedName("similartracks")
    val similarTracks: SimilarTracks
)