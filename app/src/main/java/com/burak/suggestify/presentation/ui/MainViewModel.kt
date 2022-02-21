package com.burak.suggestify.presentation.ui

import androidx.lifecycle.*
import com.burak.suggestify.domain.model.request.ArtistRequest
import com.burak.suggestify.domain.model.response.similarArtists.SimilarArtistsResponse
import com.burak.suggestify.domain.usecase.artist.GetSimilarArtistUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.io.IOError
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getSimilarArtistUseCase : GetSimilarArtistUseCase
) : ViewModel() {

    fun getSimilarArtists(request : ArtistRequest) {
        viewModelScope.launch {
            getSimilarArtistUseCase.execute(request)
                .catch {

                }
                .collect {
                    val d = ""

                }
        }
    }
}