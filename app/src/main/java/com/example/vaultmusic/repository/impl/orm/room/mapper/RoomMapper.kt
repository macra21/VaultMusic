package com.example.vaultmusic.repository.impl.orm.room.mapper

import com.example.vaultmusic.domain.model.Album
import com.example.vaultmusic.domain.model.Artist
import com.example.vaultmusic.domain.model.Playlist
import com.example.vaultmusic.domain.model.Song
import com.example.vaultmusic.repository.impl.orm.room.dbo.ArtistDbo
import com.example.vaultmusic.repository.impl.orm.room.dbo.relation.PopulatedAlbumDbo
import com.example.vaultmusic.repository.impl.orm.room.dbo.relation.PopulatedPlaylistDbo
import com.example.vaultmusic.repository.impl.orm.room.dbo.relation.PopulatedSongDbo

/**
 * Centralized mapping extensions to convert Room Database Objects (DBOs)
 * into pure Domain models.
 *
 * @author macra21
 */

/**
 * Maps a raw [ArtistDbo] to a pure domain [Artist].
 */
fun ArtistDbo.toDomain(): Artist {
    return Artist(
        id = this.id,
        name = this.name,
        debutDate = this.debutDate,
        coverPath = this.coverPath
    )
}

/**
 * Maps a joined [PopulatedAlbumDbo] to a pure domain [Album],
 * safely extracting the Artist's name from the relation.
 */
fun PopulatedAlbumDbo.toDomain(): Album {
    return Album(
        id = this.album.id,
        title = this.album.title,
        artistName = this.artist.name,
        releaseDate = this.album.releaseDate,
        coverPath = this.album.coverPath
    )
}

/**
 * Maps a joined [PopulatedSongDbo] to a pure domain [Song],
 * safely extracting both the Artist and Album names from the relations.
 */
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

/**
 * Maps a joined [PopulatedPlaylistDbo] to a pure domain [Playlist],
 * automatically calculating the song count from the joined list.
 */
fun PopulatedPlaylistDbo.toDomain(): Playlist {
    return Playlist(
        id = this.playlist.id,
        name = this.playlist.name,
        songCount = this.songs.size,
        creationDate = this.playlist.creationDate,
        coverPath = this.playlist.coverPath
    )
}
