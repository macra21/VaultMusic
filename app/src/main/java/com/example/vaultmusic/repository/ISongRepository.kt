package com.example.vaultmusic.repository

import com.example.vaultmusic.domain.model.Song
import kotlinx.coroutines.flow.Flow

/**
 * Pure domain interface for accessing and managing [Song] data.
 *
 * @author macra21
 */
interface ISongRepository {
    /**
     * Retrieves a reactive stream of all songs.
     *
     * @return A [Flow] containing a list of pure domain [Song] models.
     */
    fun getAllSongs(): Flow<List<Song>>

    /**
     * Persists a new song.
     *
     * @param song The pure domain [Song] to be saved.
     *
     * @return The newly generated unique ID (Long) for the saved song.
     */
    suspend fun saveSong(song: Song): Long

    /**
     * Updates an existing song's metadata.
     *
     * @param song The [Song] containing the updated data.
     */
    suspend fun updateSong(song: Song)

    /**
     * Removes a song based on its unique identifier.
     *
     * @param songId The unique ID of the song to delete.
     */
    suspend fun deleteSong(songId: Long)
}
