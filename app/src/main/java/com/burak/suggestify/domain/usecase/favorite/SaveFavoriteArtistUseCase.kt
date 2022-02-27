package com.burak.suggestify.domain.usecase.favorite

import com.burak.suggestify.domain.model.favorite.FavoriteArtist
import com.burak.suggestify.domain.repository.favorite.FavoritesRepository
import javax.inject.Inject

class SaveFavoriteArtistUseCase @Inject constructor(
    private val repository: FavoritesRepository
) {

    fun execute(params: FavoriteArtist) {
        return repository.saveArtist(params)
    }
}