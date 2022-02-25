package com.burak.suggestify.domain.model.track.response

import com.google.gson.annotations.SerializedName

data class SimilarTracksResponse(
    @SerializedName("similartracks")
    val similarTracks: SimilarTracks
)