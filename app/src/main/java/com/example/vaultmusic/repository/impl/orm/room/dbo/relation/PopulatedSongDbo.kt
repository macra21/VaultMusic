package com.example.vaultmusic.repository.impl.orm.room.dbo.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.vaultmusic.repository.impl.orm.room.dbo.AlbumDbo
import com.example.vaultmusic.repository.impl.orm.room.dbo.ArtistDbo
import com.example.vaultmusic.repository.impl.orm.room.dbo.SongDbo

/**
 * A Room relational projection joining a [SongDbo] with its [ArtistDbo] and [AlbumDbo].
 *
 * @author macra21
 */
data class PopulatedSongDbo(
    @Embedded
    val song: SongDbo,
    @Relation(parentColumn = "artistId", entityColumn = "id")
    val artist: ArtistDbo,
    @Relation(parentColumn = "albumId", entityColumn = "id")
    val album: AlbumDbo
)