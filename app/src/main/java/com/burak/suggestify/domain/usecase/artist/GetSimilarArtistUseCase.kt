package com.burak.suggestify.domain.usecase.artist

import com.burak.suggestify.domain.model.request.ArtistRequest
import com.burak.suggestify.domain.model.response.similarArtists.SimilarArtistsResponse
import com.burak.suggestify.domain.repository.artist.ArtistsRepository
import com.burak.suggestify.domain.usecase.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSimilarArtistUseCase @Inject constructor(
    private val repository: ArtistsRepository
) : BaseUseCase<ArtistRequest, SimilarArtistsResponse>() {

    override fun execute(params: ArtistRequest): Flow<SimilarArtistsResponse> {
        return repository.getSimilarArtists(params)
    }
}