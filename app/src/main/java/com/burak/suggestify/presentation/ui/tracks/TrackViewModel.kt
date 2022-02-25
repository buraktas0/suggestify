package com.burak.suggestify.presentation.ui.tracks

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.burak.suggestify.domain.model.track.request.TrackRequest
import com.burak.suggestify.domain.model.track.response.SimilarTracksResponse
import com.burak.suggestify.domain.usecase.track.GetSimilarTracksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrackViewModel @Inject constructor(
    private val getSimilarTracksUseCase: GetSimilarTracksUseCase
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
                limit = 10,
                mbid = null
            )
        )
    }

    private fun getSimilarTracks(request: TrackRequest) {
        viewModelScope.launch {
            getSimilarTracksUseCase.execute(request)
                .catch {

                }
                .collect {
                    similarTracksLiveData.postValue(it)
                }
        }
    }
}