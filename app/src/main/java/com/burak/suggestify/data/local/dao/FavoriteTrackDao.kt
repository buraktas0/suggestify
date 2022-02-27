package com.burak.suggestify.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.burak.suggestify.data.local.model.TrackEntity

@Dao
interface FavoriteTrackDao {

    @Query("SELECT * FROM tracks")
    suspend fun getAllTracks(): List<TrackEntity>

    @Insert
    suspend fun insertTrack(vararg track: TrackEntity)

    @Delete
    suspend fun deleteTrack(track: TrackEntity)
}