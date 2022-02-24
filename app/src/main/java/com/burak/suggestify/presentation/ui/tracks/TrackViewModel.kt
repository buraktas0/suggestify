package com.burak.suggestify.presentation.ui.tracks

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.burak.suggestify.domain.model.request.TrackRequest
import com.burak.suggestify.domain.model.response.similarTracks.SimilarTracksResponse
import com.burak.suggestify.domain.usecase.track.GetSimilarTrackUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrackViewModel @Inject constructor(
    private val getSimilarTrackUseCase: GetSimilarTrackUseCase
) : ViewModel() {

    val similarTracksLiveData = MutableLiveData<SimilarTracksResponse>()

    fun search(inputArtist: String?, inputTrack: String?) {
        inputArtist?.let { artist: String ->
            inputTrack?.let { track: String ->
                searchTrack(artist, track)
            }
        }
    }

    private fun searchTrack(artist: String, track: String) {
        getSimilarTracks(
            request = TrackRequest(
                artist = artist,
                track = track,
                autoCorrect = 1,
                limit = null,
                mbid = null
            )
        )
    }

    private fun getSimilarTracks(request: TrackRequest) {
        viewModelScope.launch {
            getSimilarTrackUseCase.execute(request)
                .catch {

                }
                .collect {
                    similarTracksLiveData.postValue(it)
                }
        }
    }
}