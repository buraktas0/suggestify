package com.burak.suggestify.presentation.ui.search

import androidx.lifecycle.*
import com.burak.suggestify.domain.model.favorite.FavoriteArtist
import com.burak.suggestify.domain.model.favorite.FavoriteTrack
import com.burak.suggestify.domain.usecase.favorite.DeleteFavoriteArtistUseCase
import com.burak.suggestify.domain.usecase.favorite.GetFavoriteArtistsUseCase
import com.burak.suggestify.domain.usecase.favorite.GetFavoriteTracksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getFavoriteArtistsUseCase: GetFavoriteArtistsUseCase,
    private val getFavoriteTracksUseCase: GetFavoriteTracksUseCase,
    private val deleteFavoriteArtistUseCase: DeleteFavoriteArtistUseCase
) : ViewModel() {

    val favoriteArtistsLiveData = MutableLiveData<List<FavoriteArtist>>()
    val favoriteTracksLiveData = MutableLiveData<List<FavoriteTrack>>()

    fun load() {
        viewModelScope.launch {
            getFavoriteArtistsUseCase.execute(null)
                .catch {

                }
                .collect {
                    favoriteArtistsLiveData.postValue(it)
                }
        }

        viewModelScope.launch {
            getFavoriteTracksUseCase.execute(null)
                .catch {

                }
                .collect {
                    favoriteTracksLiveData.postValue(it)
                }
        }
    }

    fun delete(artist: FavoriteArtist) {
        viewModelScope.launch {
            deleteFavoriteArtistUseCase.execute(artist)
        }
    }


}