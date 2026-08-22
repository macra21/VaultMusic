package com.example.vaultmusic.domain.model

/**
 * Core domain model representing a user-created playlist.
 *
 * This class enforces strict validation rules to guarantee data integrity.
 *
 * @property id The unique identifier for the playlist.
 * @property name The display name of the playlist (max 100 characters).
 * @property songCount The total number of songs currently in the playlist.
 * @property creationDate Unix timestamp (in milliseconds) representing when the playlist was created.
 * @property coverPath Local file path to the playlist's cover image.
 *
 * @author macra21
 */
data class Playlist(
    val id: Long = 0L,
    val name: String,
    val songCount: Int = 0,
    val creationDate: Long = System.currentTimeMillis(),
    val coverPath: String? = null
) {
    init {
        require(name.isNotBlank()) {
            "Playlist name cannot be blank"
        }
        require(name.length <= 250) {
            "Playlist name is too long (max length is 250 chars)"
        }
        require(songCount >= 0) {
            "A playlist cannot have a negative amount of songs"
        }
        require(creationDate > 0L) {
            "Creation date timestamp must be valid"
        }
    }
}
