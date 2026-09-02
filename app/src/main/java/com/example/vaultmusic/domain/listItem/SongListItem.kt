package com.example.vaultmusic.domain.listItem

/**
 * Lightweight UI projection of a [com.example.vaultmusic.domain.model.Song].
 *
 * Used specifically for rendering lists efficiently without loading unnecessary data.
 *
 * @property id The unique identifier for the song.
 * @property title The display title of the song.
 * @property artistName The human-readable name of the artist.
 * @property coverPath Local file path to the song's cover image.
 *
 * @author macra21
 */
data class SongListItem(
    val id: Long,
    val title: String,
    val artistName: String,
    val coverPath: String?,
    val filePath: String
)
