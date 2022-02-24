package com.burak.suggestify.presentation.ui.artists

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.burak.suggestify.domain.model.request.ArtistRequest
import com.burak.suggestify.domain.model.response.similarArtists.Artist
import com.burak.suggestify.domain.model.response.similarArtists.SimilarArtistsResponse
import com.burak.suggestify.domain.usecase.artist.GetSimilarArtistUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArtistViewModel @Inject constructor(
    private val getSimilarArtistUseCase: GetSimilarArtistUseCase
) : ViewModel() {

    val similarArtistsLiveData = MutableLiveData<SimilarArtistsResponse>()

    fun search(inputArtist: String?) {
        inputArtist?.let { artist: String ->
            searchArtist(artist)
        }
    }

    private fun searchArtist(artist: String) {
        getSimilarArtists(
            request = ArtistRequest(
                artist = artist,
                autoCorrect = 1,
                limit = null,
                mbid = null
            )
        )
    }

    private fun getSimilarArtists(request: ArtistRequest) {
        viewModelScope.launch {
            getSimilarArtistUseCase.execute(request)
                .catch {

                }
                .collect {
                    similarArtistsLiveData.postValue(it)
                }
        }
    }
}