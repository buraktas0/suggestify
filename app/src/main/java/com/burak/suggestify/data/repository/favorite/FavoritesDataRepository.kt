package com.burak.suggestify.data.repository.favorite

import com.burak.suggestify.data.local.dao.FavoriteArtistDao
import com.burak.suggestify.data.local.mapper.ArtistMapper
import com.burak.suggestify.domain.model.favorite.FavoriteArtist
import com.burak.suggestify.domain.model.favorite.FavoriteTrack
import com.burak.suggestify.domain.repository.favorite.FavoritesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoritesDataRepository @Inject constructor(
    private val artistDao: FavoriteArtistDao,
    private val artistMapper: ArtistMapper
) : FavoritesRepository {

    override fun getFavoriteArtists(): Flow<List<FavoriteArtist>> {
        return flow {
            emit(artistDao.getAllArtists().map {
                artistMapper.mapToModel(it)
            })
        }.flowOn(Dispatchers.IO)
    }

    override fun saveArtist(artist: FavoriteArtist) {
        CoroutineScope(Dispatchers.IO).launch {
            if (!artistDao.exists(artist.name)) {
                artistDao.insertArtist(artistMapper.mapToEntity(artist))
            }

        }

    }

    override fun deleteArtist(artist: FavoriteArtist) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteArtist(artist.name)
        }
    }
}