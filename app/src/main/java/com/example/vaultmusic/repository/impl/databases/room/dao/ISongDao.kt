package com.example.vaultmusic.repository.impl.databases.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.vaultmusic.repository.impl.databases.room.dbo.SongDbo
import com.example.vaultmusic.repository.impl.databases.room.dbo.relation.PopulatedSongDbo
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) for [SongDbo].
 *
 * Handles all direct SQLite database operations for audio tracks.
 *
 * @author macra21
 */
@Dao
interface ISongDao {

    /**
     * Retrieves a reactive stream of all songs.
     * Uses [@Transaction] because Room must safely join the SONGS, ALBUMS, and ARTISTS
    tables.
     */
    @Transaction
    @Query("SELECT * FROM SONGS ORDER BY title ASC")
    fun getAllSongs(): Flow<List<PopulatedSongDbo>>

    /**
     * Inserts a new song into the database.
     * @return The newly generated unique ID (Long) for the inserted song.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(song: SongDbo): Long

    @Update
    suspend fun update(song: SongDbo)

    @Delete
    suspend fun delete(song: SongDbo)
}