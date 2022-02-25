package com.burak.suggestify.domain.model.track.response

import com.burak.suggestify.domain.model.common.Image
import com.burak.suggestify.domain.model.common.Streamable

data class Track(
    val name : String,
    val playCount : Int,
    val mbid : String,
    val match : Double,
    val url : String,
    val streamable: Streamable,
    val duration : Int,
    val artist: Artist,
    val image: List<Image>
)
