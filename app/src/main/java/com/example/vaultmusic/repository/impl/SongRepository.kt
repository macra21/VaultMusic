package com.example.vaultmusic.repository.impl

import com.example.vaultmusic.domain.model.Song
import com.example.vaultmusic.repository.ISongRepository
import com.example.vaultmusic.repository.impl.orm.room.dao.IAlbumDao
import com.example.vaultmusic.repository.impl.orm.room.dao.IArtistDao
import com.example.vaultmusic.repository.impl.orm.room.dao.ISongDao
import com.example.vaultmusic.repository.impl.orm.room.dbo.AlbumDbo
import com.example.vaultmusic.repository.impl.orm.room.dbo.ArtistDbo
import com.example.vaultmusic.repository.impl.orm.room.dbo.SongDbo
import com.example.vaultmusic.repository.impl.orm.room.mapper.toDomain
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Concrete Room implementation of [ISongRepository].
 *
 * @author macra21
 */
class SongRepository @Inject constructor(
    private val songDao: ISongDao,
    private val artistDao: IArtistDao,
    private val albumDao: IAlbumDao
) : ISongRepository {

    override fun getAllSongs(): Flow<List<Song>> {
        return songDao.getAllSongs().map {
            dtoList -> dtoList.map {
                it.toDomain() }
        }
    }

    override suspend fun saveSong(song: Song): Long {
        val artistId = artistDao.insert(
            ArtistDbo(
                name = song.artistName, debutDate = null, coverPath = null
            )
        )
        val albumId = albumDao.insert(
            AlbumDbo(
                title = song.albumName, artistId = artistId, releaseDate = null, coverPath = null
            )
        )

        return songDao.insert(
            SongDbo(
                title = song.title, artistId = artistId, albumId = albumId,
                filePath = song.filePath, duration = song.duration,
                trackNumber = song.trackNumber, description = song.description,
                releaseDate = song.releaseDate, coverPath = song.coverPath
            )
        )
    }

    override suspend fun updateSong(song: Song) {
        val artistId = artistDao.insert(
            ArtistDbo(name = song.artistName, debutDate = null, coverPath = null)
        )
        val albumId = albumDao.insert(
            AlbumDbo(title = song.albumName, artistId = artistId, releaseDate = null,
                coverPath = null)
        )

        songDao.update(
            SongDbo(
                id = song.id, title = song.title, artistId = artistId, albumId = albumId,
                filePath = song.filePath, duration = song.duration,
                trackNumber = song.trackNumber, description = song.description,
                releaseDate = song.releaseDate, coverPath = song.coverPath
            )
        )
    }

    override suspend fun deleteSong(songId: Long) {
        songDao.delete(songId)
    }
}
