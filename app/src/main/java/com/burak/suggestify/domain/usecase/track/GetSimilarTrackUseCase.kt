package com.burak.suggestify.domain.usecase.track

import com.burak.suggestify.domain.model.request.TrackRequest
import com.burak.suggestify.domain.model.response.similarTracks.SimilarTracksResponse
import com.burak.suggestify.domain.model.response.similarTracks.Track
import com.burak.suggestify.domain.repository.track.TracksRepository
import com.burak.suggestify.domain.usecase.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSimilarTrackUseCase @Inject constructor(
    private val repository: TracksRepository
) : BaseUseCase<TrackRequest, SimilarTracksResponse>() {

    override fun execute(params: TrackRequest): Flow<SimilarTracksResponse> {
        return repository.getSimilarTracks(params)
    }
}