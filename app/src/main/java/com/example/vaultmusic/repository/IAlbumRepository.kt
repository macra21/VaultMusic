package com.example.vaultmusic.repository

import com.example.vaultmusic.domain.model.Album
import kotlinx.coroutines.flow.Flow

/**
 * Pure domain interface for accessing and managing [Album] data.
 *
 * @author macra21
 */
interface IAlbumRepository {
    /**
     * Retrieves a reactive stream of all albums.
     *
     * @return A [Flow] containing a list of pure domain [Album] models.
     */
    fun getAllAlbums(): Flow<List<Album>>

    /**
     * Persists a new album.
     * @param album The pure domain [Album] to be saved.
     *
     * @return The newly generated unique ID (Long) for the saved album.
     */
    suspend fun saveAlbum(album: Album): Long

    /**
     * Updates an existing album's metadata.
     *
     * @param album The [Album] containing the updated data.
     */
    suspend fun updateAlbum(album: Album)

    /**
     * Removes an album based on its unique identifier.
     *
     * @param albumId The unique ID of the album to delete.
     */
    suspend fun deleteAlbum(albumId: Long)
}