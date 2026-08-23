package com.example.vaultmusic.repository.impl.databases.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.vaultmusic.repository.impl.databases.room.dbo.PlaylistDbo
import com.example.vaultmusic.repository.impl.databases.room.dbo.crossRef.PlaylistSongCrossRef
import com.example.vaultmusic.repository.impl.databases.room.dbo.relation.PopulatedPlaylistDbo
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) for [PlaylistDbo].
 *
 * Handles operations for playlists and their Many-to-Many relationships with songs.
 *
 * @author macra21
 */
@Dao
interface IPlaylistDao {

    /**
     * Retrieves a reactive stream of all playlists, completely populated with their
    songs.
     */
    @Transaction
    @Query("SELECT * FROM PLAYLISTS ORDER BY creationDate DESC")
    fun getAllPlaylists(): Flow<List<PopulatedPlaylistDbo>>

    /**
     * Inserts a new, empty playlist into the database.
     * @return The newly generated unique ID (Long).
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(playlist: PlaylistDbo): Long

    @Update
    suspend fun update(playlist: PlaylistDbo)

    @Delete
    suspend fun delete(playlistId: Long)

    /**
     * Links an existing song to a playlist by inserting a cross-reference record.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSongToPlaylist(crossRef: PlaylistSongCrossRef)

    /**
     * Removes a song from a playlist by deleting its cross-reference record.
     */
    @Query("DELETE FROM PLAYLIST_SONG WHERE playlistId = :playlistId AND songId = :songId")
            suspend fun removeSongFromPlaylist(playlistId: Long, songId: Long)
}