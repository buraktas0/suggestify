package com.burak.suggestify.domain.repository.artist

import com.burak.suggestify.domain.model.artist.request.ArtistRequest
import com.burak.suggestify.domain.model.artist.response.SimilarArtistsResponse
import kotlinx.coroutines.flow.Flow

interface ArtistsRepository {

    fun getSimilarArtists(request: ArtistRequest): Flow<SimilarArtistsResponse>
}