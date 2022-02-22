package com.burak.suggestify.domain.model.response.common

import com.google.gson.annotations.SerializedName

data class Streamable(
    @SerializedName("#text")
    val text: String,
    val fulltrack: String
)
