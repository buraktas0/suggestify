package com.burak.suggestify.domain.repository.favorite

import com.burak.suggestify.domain.model.favorite.FavoriteArtist
import com.burak.suggestify.domain.model.favorite.FavoriteTrack
import kotlinx.coroutines.flow.Flow

interface FavoritesRepository {

    fun getFavoriteArtists(): Flow<List<FavoriteArtist>>
    fun saveArtist(artist: FavoriteArtist)
    fun deleteArtist(artist: FavoriteArtist)
}