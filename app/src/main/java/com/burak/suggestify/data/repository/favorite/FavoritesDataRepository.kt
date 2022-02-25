package com.burak.suggestify.data.repository.favorite

import com.burak.suggestify.data.local.dao.FavoriteArtistDao
import com.burak.suggestify.data.local.dao.FavoriteTrackDao
import com.burak.suggestify.data.local.model.ArtistEntity
import com.burak.suggestify.domain.model.favorite.FavoriteArtist
import com.burak.suggestify.domain.model.favorite.FavoriteTrack
import com.burak.suggestify.domain.repository.favorite.FavoritesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FavoritesDataRepository @Inject constructor(
    private val artistDao: FavoriteArtistDao,
    private val trackDao: FavoriteTrackDao
) : FavoritesRepository {

    override fun getFavoriteArtists(): Flow<List<FavoriteArtist>> {
        TODO("Not yet implemented")
    }

    override fun getFavoriteTracks(): Flow<List<FavoriteTrack>> {
        TODO("Not yet implemented")
    }

    override fun saveArtist(artist: FavoriteArtist) {
        TODO("Not yet implemented")
    }

    override fun saveTrack(track: FavoriteTrack) {
        TODO("Not yet implemented")
    }

    override fun removeArtist(artist: FavoriteArtist) {
        TODO("Not yet implemented")
    }

    override fun removeTrack(track: FavoriteTrack) {
        TODO("Not yet implemented")
    }
}