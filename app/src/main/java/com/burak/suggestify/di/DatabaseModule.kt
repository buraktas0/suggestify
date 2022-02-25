package com.burak.suggestify.di

import android.content.Context
import com.burak.suggestify.data.local.AppDatabase
import com.burak.suggestify.data.local.dao.FavoriteArtistDao
import com.burak.suggestify.data.local.dao.FavoriteTrackDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideFavoriteArtistDao(db: AppDatabase): FavoriteArtistDao {
        return db.favoriteArtistDao()
    }

    @Singleton
    @Provides
    fun provideFavoriteTrackDao(db: AppDatabase) : FavoriteTrackDao {
        return db.favoriteTrackDao()
    }

}