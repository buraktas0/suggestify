package com.burak.suggestify.domain.model.track.response

import com.google.gson.annotations.SerializedName

data class SimilarTracks(
    @SerializedName("track")
    val trackList: List<Track>
)