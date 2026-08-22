package com.example.vaultmusic.domain.model

/**
 * Core domain model representing a musical artist.
 *
 * This class enforces strict validation rules to guarantee data integrity.
 *
 * @property id The unique identifier for the artist.
 * @property name The display name of the artist (max 250 characters).
 * @property debutDate Unix timestamp (in milliseconds) of the artist's first release.
 * @property coverPath Local file path to the artist's cover image.
 *
 * @author macra21
 */
data class Artist(
    val id: Long = 0L,
    val name: String,
    val debutDate: Long? = null,
    val coverPath: String ?= null
) {
    init {
        require(name.isNotBlank()) {
            "Artist name cannot be blank"
        }
        require(name.length <= 250) {
            "Artist name is suspiciously long (max length is 250 chars)"
        }

        if (debutDate != null) {
            require(debutDate > 0L) { "Debut date timestamp must be valid" }
        }
    }
}
