package com.example.vaultmusic.repository.impl.databases.room.dbo.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.vaultmusic.domain.model.Album
import com.example.vaultmusic.repository.impl.databases.room.dbo.AlbumDbo
import com.example.vaultmusic.repository.impl.databases.room.dbo.ArtistDbo

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

fun PopulatedAlbumDbo.toDomain(): Album {
    return Album(
        id = this.album.id,
        title = this.album.title,
        artistName = this.artist.name,
        releaseDate = this.album.releaseDate,
        coverPath = this.album.coverPath
    )
}