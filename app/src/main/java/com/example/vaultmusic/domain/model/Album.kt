package com.example.vaultmusic.domain.model

/**
 * Core domain model representing a music album.
 *
 * This class enforces strict validation rules to guarantee data integrity.
 *
 * @property id The unique identifier for the album.
 * @property title The display title of the album (max 250 characters).
 * @property artistName The human-readable name of the artist who created the album.
 * @property releaseDate Unix timestamp (in milliseconds) of the album's release date.
 * @property coverPath Local file path to the album's cover image.
 *
 * @author macra21
 */
data class Album(
    val id: Long = 0L,
    val title: String,
    val artistName: String,
    val releaseYear: Int? = null,
    val releaseDate: Long? = null,
    val coverPath: String? = null
) {
    init {
        require(title.isNotBlank()) { "Album title cannot be blank" }
        require(title.length <= 250) { "Album title is suspiciously long (max length is 250 chars)" }
        require(artistName.isNotBlank()) { "Artist name cannot be blank" }

        if (releaseDate != null) {
            require(releaseDate > 0L) { "Release date timestamp must be valid" }
        }
    }
}
