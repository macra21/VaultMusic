package com.example.vaultmusic.repository.impl.orm.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.vaultmusic.repository.impl.orm.room.dao.IAlbumDao
import com.example.vaultmusic.repository.impl.orm.room.dao.IArtistDao
import com.example.vaultmusic.repository.impl.orm.room.dao.IPlaylistDao
import com.example.vaultmusic.repository.impl.orm.room.dao.ISongDao
import com.example.vaultmusic.repository.impl.orm.room.dbo.AlbumDbo
import com.example.vaultmusic.repository.impl.orm.room.dbo.ArtistDbo
import com.example.vaultmusic.repository.impl.orm.room.dbo.PlaylistDbo
import com.example.vaultmusic.repository.impl.orm.room.dbo.SongDbo
import com.example.vaultmusic.repository.impl.orm.room.dbo.crossRef.PlaylistSongCrossRef

/**
 * The main Room Database for the VaultMusic app.
 *
 * @author macra21
 */
@Database(
    entities = [
        ArtistDbo::class,
        AlbumDbo::class,
        SongDbo::class,
        PlaylistDbo::class,
        PlaylistSongCrossRef::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun artistDao(): IArtistDao
    abstract fun albumDao(): IAlbumDao
    abstract fun songDao(): ISongDao
    abstract fun playlistDao(): IPlaylistDao
}