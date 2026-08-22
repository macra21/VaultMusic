package com.example.vaultmusic.domain.listItem

/**
 * Lightweight UI projection of a [com.example.vaultmusic.domain.model.Playlist].
 *
 * Used specifically for rendering lists efficiently without loading unnecessary data.
 *
 * @property id The unique identifier for the playlist.
 * @property name The display name of the playlist.
 * @property songCount The total number of songs currently in the playlist.
 * @property coverPath Local file path to the playlist's cover image.
 *
 * @author macra21
 */
data class PlaylistListItem(
    val id: Long,
    val name: String,
    val songCount: Int,
    val coverPath: String?
)
