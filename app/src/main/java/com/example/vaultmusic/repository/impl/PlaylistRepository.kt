package com.example.vaultmusic.repository.impl

import com.example.vaultmusic.domain.model.Playlist
import com.example.vaultmusic.repository.IPlaylistRepository
import com.example.vaultmusic.repository.impl.orm.room.dao.IPlaylistDao
import com.example.vaultmusic.repository.impl.orm.room.dbo.PlaylistDbo
import com.example.vaultmusic.repository.impl.orm.room.dbo.crossRef.PlaylistSongCrossRef
import com.example.vaultmusic.repository.impl.orm.room.mapper.toDomain
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Concrete Room implementation of [IPlaylistRepository].
 * @author macra21
 */
class PlaylistRepository @Inject constructor(
    private val playlistDao: IPlaylistDao
) : IPlaylistRepository {

    override fun getAllPlaylists(): Flow<List<Playlist>> {
        return playlistDao.getAllPlaylists().map {
            dtoList -> dtoList.map {
                it.toDomain()
            }
        }
    }

    override suspend fun savePlaylist(playlist: Playlist): Long {
        return playlistDao.insert(
            PlaylistDbo(name = playlist.name, creationDate = playlist.creationDate,
                coverPath = playlist.coverPath)
        )
    }

    override suspend fun updatePlaylist(playlist: Playlist) {
        playlistDao.update(
            PlaylistDbo(
                id = playlist.id, name = playlist.name,
                creationDate = playlist.creationDate, coverPath = playlist.coverPath
            )
        )
    }

    override suspend fun deletePlaylist(playlistId: Long) {
        playlistDao.delete(playlistId)
    }

    override suspend fun addSongToPlaylist(playlistId: Long, songId: Long, position: Int) {
        playlistDao.addSongToPlaylist(
            PlaylistSongCrossRef(playlistId = playlistId, songId = songId,
                position = position)
        )
    }

    override suspend fun removeSongFromPlaylist(playlistId: Long, songId: Long) {
        playlistDao.removeSongFromPlaylist(playlistId = playlistId, songId = songId)
    }
}