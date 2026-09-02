package com.example.vaultmusic.repository.impl

import com.example.vaultmusic.domain.model.Artist
import com.example.vaultmusic.repository.IArtistRepository
import com.example.vaultmusic.repository.impl.orm.room.dao.IArtistDao
import com.example.vaultmusic.repository.impl.orm.room.dbo.ArtistDbo
import com.example.vaultmusic.repository.impl.orm.room.mapper.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Concrete Room implementation of [IArtistRepository].
 *
 * @author macra21
 */
class ArtistRepository @Inject constructor(
    private val artistDao: IArtistDao
): IArtistRepository {
    override fun getAllArtists(): Flow<List<Artist>> {
        return artistDao.getAllArtists().map {
            dtoList -> dtoList.map {
                it.toDomain()
            }
        }
    }

    override suspend fun saveArtist(artist: Artist): Long {
        return artistDao.insert(
            ArtistDbo(name = artist.name, debutDate = artist.debutDate, coverPath = artist.coverPath)
        )
    }

    override suspend fun updateArtist(artist: Artist) {
        artistDao.update(
            ArtistDbo(
                id = artist.id, name = artist.name, debutDate = artist.debutDate,
                coverPath = artist.coverPath
            )
        )
    }

    override suspend fun deleteArtist(artistId: Long) {
        artistDao.delete(artistId)
    }
}
