package com.burak.suggestify.domain.repository.artist

import com.burak.suggestify.domain.model.request.ArtistRequest
import com.burak.suggestify.domain.model.response.Artist
import kotlinx.coroutines.flow.Flow

interface ArtistsRepository {

    fun getSimilarArtists(request : ArtistRequest) : Flow<List<Artist>>
}