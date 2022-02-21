package com.burak.suggestify.data.repository.artist

import com.burak.suggestify.data.remote.ApiService
import com.burak.suggestify.domain.model.request.ArtistRequest
import com.burak.suggestify.domain.repository.artist.ArtistsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.burak.suggestify.domain.model.response.similarArtists.SimilarArtistsResponse
import kotlinx.coroutines.flow.flowOn

class ArtistsDataRepository @Inject constructor(
    private val apiService: ApiService
) : ArtistsRepository {
    override fun getSimilarArtists(request: ArtistRequest): Flow<SimilarArtistsResponse> {
        return flow {
            emit(apiService.getSimilarArtists(request.artist))
        }.flowOn(Dispatchers.IO)
    }
}