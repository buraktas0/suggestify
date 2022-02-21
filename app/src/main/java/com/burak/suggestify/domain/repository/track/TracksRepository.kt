package com.burak.suggestify.domain.repository.track

import com.burak.suggestify.domain.model.request.TrackRequest
import com.burak.suggestify.domain.model.response.Track
import kotlinx.coroutines.flow.Flow

interface TracksRepository {

    fun getSimilarTracks(request : TrackRequest) : Flow<List<Track>>
}