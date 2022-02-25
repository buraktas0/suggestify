package com.burak.suggestify.domain.usecase.favorite

import com.burak.suggestify.domain.model.favorite.FavoriteTrack
import com.burak.suggestify.domain.repository.favorite.FavoritesRepository
import com.burak.suggestify.domain.usecase.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoriteTracksUseCase @Inject constructor(
    private val repository: FavoritesRepository
) : BaseUseCase<Any?, List<FavoriteTrack>>() {

    override fun execute(params: Any?): Flow<List<FavoriteTrack>> {
        return repository.getFavoriteTracks()
    }

}