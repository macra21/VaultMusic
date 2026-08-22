package com.example.vaultmusic.repository.impl.databases.room.dbo.crossRef

import androidx.room.Entity

/**
 * A Many-to-Many cross-reference table between [com.example.vaultmusic.repository.impl.databases.room.dbo.PlaylistDbo]
 * and [com.example.vaultmusic.repository.impl.databases.room.dbo.SongDbo].
 */
@Entity(
    tableName = "PLAYLIST_SONG",
    primaryKeys = ["playlistId", "songId"])
data class PlaylistSongCrossRef(
    val playlistId: Long,
    val songId: Long,
    val position: Int
)