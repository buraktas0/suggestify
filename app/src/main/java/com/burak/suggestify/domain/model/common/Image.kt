package com.burak.suggestify.domain.model.common

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("#text")
    val text : String,
    val size : String
)
