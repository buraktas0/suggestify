package com.burak.suggestify.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.burak.suggestify.data.local.model.ArtistEntity

@Dao
interface FavoriteArtistDao {

    @Query("SELECT * FROM artists")
    suspend fun getAllArtists(): List<ArtistEntity>

    @Insert
    suspend fun insertArtist(vararg artist: ArtistEntity)

    @Query("SELECT EXISTS (SELECT 1 FROM artists WHERE name = :name)")
    suspend fun exists(name: String): Boolean

    @Query("DELETE FROM artists WHERE name = :name")
    suspend fun deleteArtist(name: String)
}