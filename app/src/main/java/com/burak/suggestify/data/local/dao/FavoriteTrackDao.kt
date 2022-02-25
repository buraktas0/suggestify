package com.burak.suggestify.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavoriteTrackDao {

    @Query("SELECT * FROM tracks")
    fun getAllTracks(): List<FavoriteTrackDao>

    @Insert
    fun insertTrack(vararg track: FavoriteTrackDao)

    @Delete
    fun deleteTrack(track: FavoriteTrackDao)
}