package com.example.vaultmusic.domain.listItem

/**
 * Lightweight UI projection of an [com.example.vaultmusic.domain.model.Artist].
 *
 * Used specifically for rendering lists efficiently without loading unnecessary data.
 *
 * @property id The unique identifier for the artist.
 * @property name The display name of the artist.
 * @property coverPath Local file path to the artist's cover image.
 *
 * @author macra21
 */
data class ArtistListItem(
    val id: Long = 0L,
    val name: String,
    val coverPath: String?
)
