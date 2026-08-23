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
     * Retrieves a reactive stream of all playlists, completely populated with their songs.
     *
     * @return A [Flow] emitting a list of populated playlist relations.
     */
    @Transaction
    @Query("SELECT * FROM PLAYLISTS ORDER BY creationDate DESC")
    fun getAllPlaylists(): Flow<List<PopulatedPlaylistDbo>>

    /**
     * Inserts a new, empty playlist into the database.
     *
     * @param playlist The [PlaylistDbo] entity to save.
     *
     * @return The newly generated unique ID (Long).
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(playlist: PlaylistDbo): Long

    /**
     * Updates an existing playlist in the database based on its Primary Key
     *
     * @param playlist The [PlaylistDbo] containing the updated values.
     */
    @Update
    suspend fun update(playlist: PlaylistDbo)

    /**
     * Removes an entire playlist from the database.
     *
     * @param playlistId The Primary Key of the playlist to delete.
     */
    @Delete
    suspend fun delete(playlistId: Long)

    /**
     * Links an existing song to a playlist by inserting a cross-reference record.
     *
     * @param crossRef The [PlaylistSongCrossRef] mapping the song to the playlist.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSongToPlaylist(crossRef: PlaylistSongCrossRef)

    /**
     * Removes a song from a playlist by deleting its cross-reference record.
     *
     * @param playlistId The ID of the playlist.
     * @param songId The ID of the song to remove from the playlist.
     */
    @Query("DELETE FROM PLAYLIST_SONG WHERE playlistId = :playlistId AND songId = :songId")
            suspend fun removeSongFromPlaylist(playlistId: Long, songId: Long)
}