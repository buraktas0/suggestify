package com.burak.suggestify.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.burak.suggestify.data.local.dao.FavoriteArtistDao
import com.burak.suggestify.data.local.dao.FavoriteTrackDao
import com.burak.suggestify.data.local.model.ArtistEntity
import com.burak.suggestify.data.local.model.TrackEntity

@Database(
    entities = [
        ArtistEntity::class,
        TrackEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun favoriteArtistDao(): FavoriteArtistDao
    abstract fun favoriteTrackDao(): FavoriteTrackDao

    companion object {

        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: build(context).also { instance = it }
            }
        }

        private fun build(context: Context) : AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "favDb"
            ).build()
        }
    }


}