package com.burak.suggestify.domain.usecase.track

import com.burak.suggestify.domain.model.request.TrackRequest
import com.burak.suggestify.domain.model.response.Track
import com.burak.suggestify.domain.repository.track.TracksRepository
import com.burak.suggestify.domain.usecase.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSimilarTrackUseCase @Inject constructor(
    private val repository: TracksRepository
) : BaseUseCase<TrackRequest, Track>() {

    override fun execute(params: TrackRequest): Flow<Track> {
        TODO("Not yet implemented")
    }
}