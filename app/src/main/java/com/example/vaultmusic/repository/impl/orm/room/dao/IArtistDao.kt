package com.example.vaultmusic.repository.impl.orm.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.vaultmusic.repository.impl.orm.room.dbo.ArtistDbo
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
     *
     * @return A [Flow] containing a list of artist entities.
     */
    @Query("SELECT * FROM ARTISTS ORDER BY name ASC")
    fun getAllArtists(): Flow<List<ArtistDbo>>

    /**
     * Inserts a new artist into the database.
     *
     * @param artist The [ArtistDbo] entity to save.
     *
     * @return The newly generated unique ID (Long) for the inserted artist.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(artist: ArtistDbo): Long

    /**
     * Updates an existing artist in the database based on its Primary Key.
     *
     * @param artist The [ArtistDbo] containing the updated values.
     */
    @Update
    suspend fun update(artist: ArtistDbo)

    /**
     * Removes an artist from the database based on its Primary Key.
     *
     * @param artistId The Primary Key of the artist to delete.
     */
    @Query("DELETE FROM ARTISTS WHERE id = :artistId")
    suspend fun delete(artistId: Long)
}