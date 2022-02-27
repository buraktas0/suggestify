package com.burak.suggestify.domain.usecase.favorite

import com.burak.suggestify.data.local.mapper.ArtistMapper
import com.burak.suggestify.domain.model.favorite.FavoriteArtist
import com.burak.suggestify.domain.repository.favorite.FavoritesRepository
import com.burak.suggestify.domain.usecase.BaseUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetFavoriteArtistsUseCase @Inject constructor(
    private val repository: FavoritesRepository,
    private val mapper: ArtistMapper
) : BaseUseCase<Any?, List<FavoriteArtist>>() {

    override fun execute(params: Any?): Flow<List<FavoriteArtist>> {
        return repository.getFavoriteArtists()
    }

}