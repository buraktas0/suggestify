package com.burak.suggestify.data.remote

import com.burak.suggestify.domain.model.response.similarArtists.SimilarArtistsResponse
import com.burak.suggestify.domain.model.response.similarTracks.SimilarTracksResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/2.0/?method=artist.getSimilar")
    suspend fun getSimilarArtists(
        @Query("artist") artist: String
    ): SimilarArtistsResponse

    @GET("/2.0/?method=track.getSimilar")
    suspend fun getSimilarTracks(
        @Query("artist") artist: String,
        @Query("track") track: String
    ): SimilarTracksResponse
}