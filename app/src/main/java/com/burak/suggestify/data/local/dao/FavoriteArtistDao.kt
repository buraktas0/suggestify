package com.burak.suggestify.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavoriteArtistDao {

    @Query("SELECT * FROM artists")
    fun getAllArtists(): List<FavoriteArtistDao>

    @Insert
    fun insertArtist(vararg artist: FavoriteArtistDao)

    @Delete
    fun deleteArtist(artist: FavoriteArtistDao)
}