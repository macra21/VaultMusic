package com.example.vaultmusic.repository.impl.orm.room.dbo.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.vaultmusic.repository.impl.orm.room.dbo.AlbumDbo
import com.example.vaultmusic.repository.impl.orm.room.dbo.ArtistDbo

/**
 * A Room relational projection joining an [AlbumDbo] with its [ArtistDbo].
 *
 * @author macra21
 */
data class PopulatedAlbumDbo(
    @Embedded
    val album: AlbumDbo,
    @Relation(
        parentColumn = "artistId",
        entityColumn = "id"
    )
    val artist: ArtistDbo
)
