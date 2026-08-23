package com.example.vaultmusic.repository

import com.example.vaultmusic.domain.model.Playlist
import kotlinx.coroutines.flow.Flow

/**
 * Pure domain interface for accessing and managing [Playlist] data.
 *
 * @author macra21
 */
interface IPlaylistRepository {
    /**
     * Retrieves a reactive stream of all playlists.
     *
     * @return A [Flow] containing a list of pure domain [Playlist] models.
     */
    fun getAllPlaylists(): Flow<List<Playlist>>

    /**
     * Persists a new, empty playlist.
     *
     * @param playlist The pure domain [Playlist] to be saved.
     *
     * @return The newly generated unique ID (Long) for the saved playlist.
     */
    suspend fun savePlaylist(playlist: Playlist): Long

    /**
     * Updates the metadata of an existing playlist.
     *
     * @param playlist The [Playlist] containing the updated data.
     */
    suspend fun updatePlaylist(playlist: Playlist)

    /**
     * Removes an entire playlist from the database based on its unique identifier.
     *
     * @param playlistId The unique ID of the playlist to delete.
     */
    suspend fun deletePlaylist(playlistId: Long)

    /**
     * Adds a specific song to a playlist.
     *
     * @param playlistId The ID of the playlist.
     * @param songId The ID of the song to add.
     * @param position The intended track position inside the playlist.
     */
    suspend fun addSongToPlaylist(playlistId: Long, songId: Long, position: Int)

    /**
     * Removes a specific song from a playlist.
     *
     * @param playlistId The ID of the playlist.
     * @param songId The ID of the song to remove.
     */
    suspend fun removeSongFromPlaylist(playlistId: Long, songId: Long)
}