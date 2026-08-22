package com.example.vaultmusic.repository.impl.databases.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.vaultmusic.repository.impl.databases.room.dbo.ArtistDbo
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) for [ArtistDbo].
 *
 * Handles all direct SQLite database operations for artists.
 *
 * @author macra21
 */
@Dao
interface IArtistDao {

    /**
     * Retrieves a reactive stream of all artists in alphabetical order.
     */
    @Query("SELECT * FROM ARTISTS ORDER BY name ASC")
    fun getAllArtists(): Flow<List<ArtistDbo>>

    /**
     * Inserts a new artist into the database.
     * @return The newly generated unique ID (Long) for the inserted artist.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(artist: ArtistDbo): Long

    @Update
    suspend fun update(artist: ArtistDbo)

    @Delete
    suspend fun delete(artist: ArtistDbo)
}