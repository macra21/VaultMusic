package com.example.vaultmusic.di

import android.content.Context
import androidx.room.Room
import com.example.vaultmusic.repository.impl.orm.room.AppDatabase
import com.example.vaultmusic.repository.impl.orm.room.dao.IAlbumDao
import com.example.vaultmusic.repository.impl.orm.room.dao.IArtistDao
import com.example.vaultmusic.repository.impl.orm.room.dao.IPlaylistDao
import com.example.vaultmusic.repository.impl.orm.room.dao.ISongDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
/**
 * Configuration file for dao classes dependency injection.
 */
@Module //Just like @Configuration in Spring
@InstallIn(SingletonComponent::class) // Same instance of the dependencies for the entire lifetime of the app
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "vault_music.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideSongDao(database: AppDatabase): ISongDao = database.songDao()

    @Provides
    @Singleton
    fun provideArtistDao(database: AppDatabase): IArtistDao = database.artistDao()

    @Provides
    @Singleton
    fun provideAlbumDao(database: AppDatabase): IAlbumDao = database.albumDao()

    @Provides
    @Singleton
    fun providePlaylistDao(database: AppDatabase): IPlaylistDao = database.playlistDao()
}
