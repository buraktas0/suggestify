package com.burak.suggestify.data.remote

import com.burak.suggestify.domain.model.response.Artist
import com.burak.suggestify.domain.model.response.Track
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/?method=artist.getSimilar")
    suspend fun getSimilarArtists(
        @Query("artist") artist: String
    ): List<Artist>

    @GET("/?method=track.getSimilar")
    suspend fun getSimilarTracks(
        @Query("artist") artist: String,
        @Query("track") track: String
    ): List<Track>
}