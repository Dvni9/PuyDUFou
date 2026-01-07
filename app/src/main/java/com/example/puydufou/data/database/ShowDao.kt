package com.example.puydufou.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.puydufou.data.model.Show
import kotlinx.coroutines.flow.Flow

@Dao
interface ShowDao {
    @Query("SELECT * FROM shows")
    fun getAllShows(): Flow<List<Show>>

    @Query("SELECT * FROM shows WHERE id = :showId")
    suspend fun getShowById(showId: Int): Show?

    @Query("SELECT * FROM shows WHERE isFavorite = 1")
    fun getFavoriteShows(): Flow<List<Show>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(shows: List<Show>)

    @Update
    suspend fun updateShow(show: Show)

    @Query("UPDATE shows SET isFavorite = :isFavorite WHERE id = :showId")
    suspend fun updateFavoriteStatus(showId: Int, isFavorite: Boolean)

    @Query("DELETE FROM shows")
    suspend fun deleteAll()
}