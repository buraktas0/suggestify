package com.burak.suggestify.domain.usecase.artist

import com.burak.suggestify.domain.model.request.ArtistRequest
import com.burak.suggestify.domain.model.response.Artist
import com.burak.suggestify.domain.repository.artist.ArtistsRepository
import com.burak.suggestify.domain.usecase.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSimilarArtistUseCase @Inject constructor(
    private val repository: ArtistsRepository
) : BaseUseCase<ArtistRequest, List<Artist>>() {

    override fun execute(params: ArtistRequest): Flow<List<Artist>> {
        return repository.getSimilarArtists(params)
    }
}