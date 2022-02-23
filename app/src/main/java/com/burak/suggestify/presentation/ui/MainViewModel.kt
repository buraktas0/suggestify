package com.burak.suggestify.presentation.ui

import androidx.lifecycle.*
import com.burak.suggestify.domain.model.request.ArtistRequest
import com.burak.suggestify.domain.model.request.TrackRequest
import com.burak.suggestify.domain.model.response.similarArtists.SimilarArtistsResponse
import com.burak.suggestify.domain.model.response.similarTracks.SimilarTracksResponse
import com.burak.suggestify.domain.usecase.artist.GetSimilarArtistUseCase
import com.burak.suggestify.domain.usecase.track.GetSimilarTrackUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.io.IOError
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getSimilarArtistUseCase: GetSimilarArtistUseCase,
    private val getSimilarTrackUseCase: GetSimilarTrackUseCase
) : ViewModel() {

    val similarArtistsLiveData = MutableLiveData<SimilarArtistsResponse>()
    val similarTracksLiveData = MutableLiveData<SimilarTracksResponse>()

    fun getSimilarArtists(request: ArtistRequest) {
        viewModelScope.launch {
            getSimilarArtistUseCase.execute(request)
                .catch {

                }
                .collect {
                    similarArtistsLiveData.postValue(it)
                }
        }
    }

    fun getSimilarTracks(request: TrackRequest) {
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