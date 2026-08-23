package com.example.vaultmusic.repository.impl

import com.example.vaultmusic.domain.model.Album
import com.example.vaultmusic.repository.IAlbumRepository
import com.example.vaultmusic.repository.impl.orm.room.dao.IAlbumDao
import com.example.vaultmusic.repository.impl.orm.room.dao.IArtistDao
import com.example.vaultmusic.repository.impl.orm.room.dbo.AlbumDbo
import com.example.vaultmusic.repository.impl.orm.room.dbo.ArtistDbo
import com.example.vaultmusic.repository.impl.orm.room.mapper.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Concrete Room implementation of [IAlbumRepository].
 *
 * @author macra21
 */
class AlbumRepository @Inject constructor(
    private val albumDao: IAlbumDao,
    private val artistDao: IArtistDao
) : IAlbumRepository {
    override fun getAllAlbums(): Flow<List<Album>> {
        return albumDao.getAllAlbums().map {
            dtoList -> dtoList.map {
                it.toDomain()
            }
        }
    }

    override suspend fun saveAlbum(album: Album): Long {
        val artistId = artistDao.insert(
            ArtistDbo(name = album.artistName, debutDate = null, coverPath = null)
        )

        return albumDao.insert(
            AlbumDbo(title = album.title, artistId = artistId, releaseDate = album.releaseDate,
                coverPath = album.coverPath)
        )
    }

    override suspend fun updateAlbum(album: Album) {
        val artistId = artistDao.insert(
            ArtistDbo(name = album.artistName, debutDate = null, coverPath = null)
        )
        val updatedDbo = AlbumDbo(id = album.id, title = album.title, artistId = artistId,
            releaseDate = album.releaseDate, coverPath = album.coverPath)

        albumDao.update(updatedDbo)
    }

    override suspend fun deleteAlbum(albumId: Long) {
        albumDao.delete(albumId)
    }
}