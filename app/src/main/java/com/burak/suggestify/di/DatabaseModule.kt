package com.burak.suggestify.di

import android.content.Context
import com.burak.suggestify.data.local.AppDatabase
import com.burak.suggestify.data.local.dao.FavoriteArtistDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideFavoriteArtistDao(db: AppDatabase): FavoriteArtistDao {
        return db.favoriteArtistDao()
    }

}