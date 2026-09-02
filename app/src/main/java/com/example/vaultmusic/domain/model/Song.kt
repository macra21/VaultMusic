package com.example.vaultmusic.domain.model

/**
 * Core domain model representing an individual audio track.
 *
 * This class enforces strict validation rules to guarantee data integrity.
 * The duration must be strictly positive, and track numbers cannot be negative.
 *
 * @property id The unique identifier for the song.
 * @property title The display title of the song (max 250 characters).
 * @property artistName The human-readable name of the artist, formatted for UI display.
 * @property albumName The human-readable name of the album.
 * @property filePath The absolute local file path where the audio file is stored.
 * @property duration The length of the song in seconds.
 * @property trackNumber The position of the song within its album.
 * @property description Additional details, lyrics, or metadata associated with the song.
 * @property releaseDate Unix timestamp (in milliseconds) of the song's release date.
 * @property coverPath Local file path to the song's cover image.
 *
 * @author macra21
 */
data class Song(
    val id: Long = 0L,
    val title: String,
    val artistName: String,
    val albumName: String,
    val filePath: String,
    val duration: Double,
    val trackNumber: Int,
    val description: String,
    val releaseDate: Long? = null,
    val coverPath: String ?= null
) {
    init {
        require(title.isNotBlank()) {
            "Song title cannot be blank"
        }
        require(title.length <= 250) {
            "Song title is suspiciously long (max length is 250 chars)"
        }

        require(artistName.isNotBlank()){
            "Artist name cannot be blank"
        }
        require(artistName.length <= 250) {
            "Artist name is suspiciously long (max length is 250 chars)"
        }

        require(albumName.isNotBlank()){
            "Album name cannot be blank"
        }
        require(albumName.length <= 250) {
            "Album name is suspiciously long (max length is 250 chars)"
        }

        require(filePath.isNotBlank()) {
            "File path must be valid"
        }

        require(duration > 0.0) {
            "Song duration must be greater than 0"
        }

        require(trackNumber >= 0) {
            "Track number cannot be negative"
        }

        if (releaseDate != null) {
            require(releaseDate > 0L) { "Release date timestamp must be valid" }
        }
    }
}
