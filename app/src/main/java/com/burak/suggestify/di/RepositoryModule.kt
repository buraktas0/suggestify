package com.burak.suggestify.di

import com.burak.suggestify.data.local.dao.FavoriteArtistDao
import com.burak.suggestify.data.local.dao.FavoriteTrackDao
import com.burak.suggestify.data.local.mapper.ArtistMapper
import com.burak.suggestify.data.local.mapper.TrackMapper
import com.burak.suggestify.data.remote.ApiService
import com.burak.suggestify.data.repository.artist.ArtistsDataRepository
import com.burak.suggestify.data.repository.favorite.FavoritesDataRepository
import com.burak.suggestify.data.repository.track.TracksDataRepository
import com.burak.suggestify.domain.repository.artist.ArtistsRepository
import com.burak.suggestify.domain.repository.favorite.FavoritesRepository
import com.burak.suggestify.domain.repository.track.TracksRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideArtistsRepository(apiService: ApiService) : ArtistsRepository {
        return ArtistsDataRepository(apiService)
    }

    @Singleton
    @Provides
    fun provideTracksRepository(apiService: ApiService) : TracksRepository {
        return TracksDataRepository(apiService)
    }

    @Singleton
    @Provides
    fun provideFavoritesRepository(artistDao: FavoriteArtistDao, trackDao: FavoriteTrackDao) : FavoritesRepository {
        return FavoritesDataRepository(artistDao, trackDao, ArtistMapper(), TrackMapper())
    }
}