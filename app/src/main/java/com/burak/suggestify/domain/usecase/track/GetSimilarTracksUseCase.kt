package com.burak.suggestify.domain.usecase.track

import com.burak.suggestify.domain.model.track.request.TrackRequest
import com.burak.suggestify.domain.model.track.response.SimilarTracksResponse
import com.burak.suggestify.domain.repository.track.TracksRepository
import com.burak.suggestify.domain.usecase.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSimilarTracksUseCase @Inject constructor(
    private val repository: TracksRepository
) : BaseUseCase<TrackRequest, SimilarTracksResponse>() {

    override fun execute(params: TrackRequest): Flow<SimilarTracksResponse> {
        return repository.getSimilarTracks(params)
    }
}