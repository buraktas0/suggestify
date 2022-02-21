package com.burak.suggestify.data.repository

import com.burak.suggestify.data.remote.ApiService
import com.burak.suggestify.domain.model.request.TrackRequest
import com.burak.suggestify.domain.model.response.Track
import com.burak.suggestify.domain.repository.track.TracksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TracksDataRepository @Inject constructor(
    private val apiService : ApiService
) : TracksRepository
{
    override fun getSimilarTracks(request : TrackRequest): Flow<List<Track>> {
        return flow {
          emit(apiService.getSimilarTracks(request.artist, request.track))
        }
    }
}