package com.example.vaultmusic.repository

import com.example.vaultmusic.domain.model.Artist
import kotlinx.coroutines.flow.Flow

/**
 * Pure repository interface for managing [Artist] data.
 *
 * @author macra21
 */
interface IArtistRepository {
    /**
     * Retrieves a reactive stream of all artists.
     *
     * @return A [Flow] containing a list of pure domain [Artist] models.
     */
    fun getAllArtists(): Flow<List<Artist>>

    /**
     * Persists a new artist.
     *
     * @param artist The pure domain [Artist] to be saved.
     *
     * @return The newly generated unique ID (Long) for the saved artist.
     */
    suspend fun saveArtist(artist: Artist): Long

    /**
     * Updates an existing artist's metadata.
     *
     * @param artist The [Artist] containing the updated data.
     */
    suspend fun updateArtist(artist: Artist)

    /**
     * Removes an artist based on its unique identifier.
     *
     * @param artistId The unique ID of the artist to delete.
     */
    suspend fun deleteArtist(artistId: Long)
}
