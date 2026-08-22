package com.example.vaultmusic.domain.listItem

/**
 * Lightweight UI projection of an [com.example.vaultmusic.domain.model.Album].
 *
 * Used specifically for rendering lists efficiently without loading unnecessary data.
 *
 * @property id The unique identifier for the album.
 * @property title The display title of the album.
 * @property artistName The human-readable name of the artist who created the album.
 * @property coverPath Local file path to the album's cover image.
 *
 * @author macra21
 */
data class AlbumListItem(
    val id: Long,
    val title: String,
    val artistName: String,
    val coverPath: String?
)
