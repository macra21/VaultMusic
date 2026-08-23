package com.example.vaultmusic.repository.impl.orm.room.dbo.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.vaultmusic.repository.impl.orm.room.dbo.PlaylistDbo
import com.example.vaultmusic.repository.impl.orm.room.dbo.SongDbo
import com.example.vaultmusic.repository.impl.orm.room.dbo.crossRef.PlaylistSongCrossRef

/**
 * A Room relational projection fetching a [PlaylistDbo] and all of its associated [SongDbo]s.
 *
 * @author macra21
 */
data class PopulatedPlaylistDbo(
    @Embedded
    val playlist: PlaylistDbo,

    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = PlaylistSongCrossRef::class,
            parentColumn = "playlistId",
            entityColumn = "songId"
        )
    )
    val songs: List<SongDbo>
)