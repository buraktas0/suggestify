package com.burak.suggestify.data.repository

import com.burak.suggestify.data.remote.ApiService
import com.burak.suggestify.data.repository.artist.ArtistsDataRepository
import com.burak.suggestify.data.repository.track.TracksDataRepository
import com.burak.suggestify.domain.repository.artist.ArtistsRepository
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
}