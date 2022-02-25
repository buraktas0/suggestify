package com.burak.suggestify.domain.repository.track

import com.burak.suggestify.domain.model.track.request.TrackRequest
import com.burak.suggestify.domain.model.track.response.SimilarTracksResponse
import kotlinx.coroutines.flow.Flow

interface TracksRepository {

    fun getSimilarTracks(request : TrackRequest) : Flow<SimilarTracksResponse>
}