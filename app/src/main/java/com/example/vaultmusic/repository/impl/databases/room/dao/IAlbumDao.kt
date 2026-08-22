package com.example.vaultmusic.repository.impl.databases.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.vaultmusic.repository.impl.databases.room.dbo.AlbumDbo
import com.example.vaultmusic.repository.impl.databases.room.dbo.relation.PopulatedAlbumDbo
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) for [AlbumDbo].
 *
 * Handles all direct SQLite database operations for albums.
 *
 * @author macra21
 */
@Dao
interface IAlbumDao {

    /**
     * Retrieves a reactive stream of all albums.
     * Uses [@Transaction] because Room must query both the ALBUMS and ARTISTS tables
     * to build the [PopulatedAlbumDbo] relation.
     */
    @Transaction
    @Query("SELECT * FROM ALBUMS ORDER BY title ASC")
    fun getAllAlbums(): Flow<List<PopulatedAlbumDbo>>

    /**
     * Inserts a new album into the database.
     * @return The newly generated unique ID (Long) for the inserted album.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(album: AlbumDbo): Long

    @Update
    suspend fun update(album: AlbumDbo)

    @Delete
    suspend fun delete(album: AlbumDbo)
}