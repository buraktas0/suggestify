package com.burak.suggestify.data.repository

import com.burak.suggestify.data.remote.ApiService
import com.burak.suggestify.domain.model.request.ArtistRequest
import com.burak.suggestify.domain.model.response.Artist
import com.burak.suggestify.domain.repository.artist.ArtistsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ArtistsDataRepository @Inject constructor(
    private val apiService : ApiService
) : ArtistsRepository
{
    override fun getSimilarArtists(request : ArtistRequest): Flow<List<Artist>> {
        return flow {
            emit(apiService.getSimilarArtists(request.artist))
        }
    }
}