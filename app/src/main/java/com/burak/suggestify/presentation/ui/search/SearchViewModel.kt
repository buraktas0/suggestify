package com.burak.suggestify.presentation.ui.search

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
import javax.inject.Inject

class SearchViewModel : ViewModel() {

    //TODO room db implementation for storing favourite search results

}