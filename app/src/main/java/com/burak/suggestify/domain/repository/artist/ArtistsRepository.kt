package com.burak.suggestify.domain.repository.artist

import com.burak.suggestify.domain.model.request.ArtistRequest
import com.burak.suggestify.domain.model.response.similarArtists.SimilarArtistsResponse
import kotlinx.coroutines.flow.Flow

interface ArtistsRepository {

    fun getSimilarArtists(request : ArtistRequest) : Flow<SimilarArtistsResponse>
}