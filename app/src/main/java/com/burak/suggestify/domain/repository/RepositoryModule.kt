package com.burak.suggestify.domain.repository

import com.burak.suggestify.data.remote.ApiService
import com.burak.suggestify.data.repository.ArtistsDataRepository
import com.burak.suggestify.data.repository.TracksDataRepository
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
    fun provideArtistsRepository(apiService: ApiService) : ArtistsDataRepository {
        return ArtistsDataRepository(apiService)
    }

    @Singleton
    @Provides
    fun provideTracksRepository(apiService: ApiService) : TracksDataRepository {
        return TracksDataRepository(apiService)
    }
}