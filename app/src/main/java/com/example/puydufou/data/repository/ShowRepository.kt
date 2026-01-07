package com.example.puydufou.data.repository

import androidx.lifecycle.LiveData
import com.example.puydufou.data.database.ShowDao
import com.example.puydufou.data.model.Show
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class ShowRepository(private val showDao: ShowDao) {

    // Para ShowsFragment
    val allShows: Flow<List<Show>> = showDao.getAllShows()

    // Para FavoritesFragment (solo favoritos)
    val favoriteShows: Flow<List<Show>> = showDao.getFavoriteShows()

    suspend fun getShowById(showId: Int): Show? {
        return withContext(Dispatchers.IO) {
            showDao.getShowById(showId)
        }
    }

    suspend fun insertShows(shows: List<Show>) {
        withContext(Dispatchers.IO) {
            showDao.insertAll(shows)
        }
    }

    suspend fun updateShow(show: Show) {
        withContext(Dispatchers.IO) {
            showDao.updateShow(show)
        }
    }

    suspend fun toggleFavorite(showId: Int, isFavorite: Boolean) {
        withContext(Dispatchers.IO) {
            showDao.updateFavoriteStatus(showId, isFavorite)
        }
    }

    suspend fun initializeDatabase() {
        val shows = DataGenerator.getSampleShows()
        showDao.deleteAll()
        showDao.insertAll(shows)
    }
}