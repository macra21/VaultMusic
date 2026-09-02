package com.example.vaultmusic.repository.impl.orm.room.dbo.crossRef

import androidx.room.Entity

/**
 * A Many-to-Many cross-reference table between [com.example.vaultmusic.repository.impl.orm.room.dbo.PlaylistDbo]
 * and [com.example.vaultmusic.repository.impl.orm.room.dbo.SongDbo].
 *
 * @property playlistId The ID of the playlist.
 * @property songId The ID of the song inside the playlist.
 * @property position The track order position inside the playlist.
 *
 * @author macra21
 */
@Entity(
    tableName = "PLAYLIST_SONG",
    primaryKeys = ["playlistId", "songId"]
)
data class PlaylistSongCrossRef(
    val playlistId: Long,
    val songId: Long,
    val position: Int
)
