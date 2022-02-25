package com.burak.suggestify.presentation.ui.artists

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.burak.suggestify.domain.model.artist.request.ArtistRequest
import com.burak.suggestify.domain.model.artist.response.SimilarArtistsResponse
import com.burak.suggestify.domain.usecase.artist.GetSimilarArtistsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArtistViewModel @Inject constructor(
    private val getSimilarArtistsUseCase: GetSimilarArtistsUseCase
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
                limit = 10,
                mbid = null
            )
        )
    }

    private fun getSimilarArtists(request: ArtistRequest) {
        viewModelScope.launch {
            getSimilarArtistsUseCase.execute(request)
                .catch {

                }
                .collect {
                    similarArtistsLiveData.postValue(it)
                }
        }
    }
}