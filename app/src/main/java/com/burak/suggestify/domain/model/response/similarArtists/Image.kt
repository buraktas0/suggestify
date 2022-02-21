package com.burak.suggestify.domain.model.response.similarArtists

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("#text")
    val text : String,
    val size : String
)
