package com.example.vaultmusic.repository.impl.databases.room.dbo.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.vaultmusic.domain.model.Song
import com.example.vaultmusic.repository.impl.databases.room.dbo.AlbumDbo
import com.example.vaultmusic.repository.impl.databases.room.dbo.ArtistDbo
import com.example.vaultmusic.repository.impl.databases.room.dbo.SongDbo

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

fun PopulatedSongDbo.toDomain(): Song {
    return Song(
        id = this.song.id,
        title = this.song.title,
        artistName = this.artist.name,
        albumName = this.album.title,
        filePath = this.song.filePath,
        duration = this.song.duration,
        trackNumber = this.song.trackNumber,
        description = this.song.description,
        releaseDate = this.song.releaseDate,
        coverPath = this.song.coverPath
    )
}