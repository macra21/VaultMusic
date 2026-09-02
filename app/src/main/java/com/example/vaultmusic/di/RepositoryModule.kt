package com.example.vaultmusic.di

import com.example.vaultmusic.repository.IAlbumRepository
import com.example.vaultmusic.repository.IArtistRepository
import com.example.vaultmusic.repository.IPlaylistRepository
import com.example.vaultmusic.repository.ISongRepository
import com.example.vaultmusic.repository.impl.AlbumRepository
import com.example.vaultmusic.repository.impl.ArtistRepository
import com.example.vaultmusic.repository.impl.PlaylistRepository
import com.example.vaultmusic.repository.impl.SongRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dependency Injection module that links pure Domain Repository Interfaces
 * to their concrete Room database implementations.
 *
 * @author macra21
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindArtistRepository(impl: ArtistRepository): IArtistRepository

    @Binds
    @Singleton
    abstract fun bindAlbumRepository(impl: AlbumRepository): IAlbumRepository

    @Binds
    @Singleton
    abstract fun bindSongRepository(impl: SongRepository): ISongRepository

    @Binds
    @Singleton
    abstract fun bindPlaylistRepository(impl: PlaylistRepository): IPlaylistRepository
}
