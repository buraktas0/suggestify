package com.burak.suggestify.domain.usecase.artist

import com.burak.suggestify.domain.model.artist.request.ArtistRequest
import com.burak.suggestify.domain.model.artist.response.SimilarArtistsResponse
import com.burak.suggestify.domain.repository.artist.ArtistsRepository
import com.burak.suggestify.domain.usecase.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSimilarArtistsUseCase @Inject constructor(
    private val repository: ArtistsRepository
) : BaseUseCase<ArtistRequest, SimilarArtistsResponse>() {

    override fun execute(params: ArtistRequest): Flow<SimilarArtistsResponse> {
        return repository.getSimilarArtists(params)
    }
}