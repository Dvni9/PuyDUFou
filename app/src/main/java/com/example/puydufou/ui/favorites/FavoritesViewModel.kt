package com.example.puydufou.ui.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.puydufou.data.model.Show
import com.example.puydufou.data.repository.ShowRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModelProvider


class FavoritesViewModel(private val repository: ShowRepository) : ViewModel() {

    // Obtener solo los favoritos
    val favorites: LiveData<List<Show>> = repository.favoriteShows.asLiveData()

    fun toggleFavorite(showId: Int, isFavorite: Boolean) {
        viewModelScope.launch {
            repository.toggleFavorite(showId, isFavorite)
        }
    }
}


class FavoritesViewModelFactory(
    private val repository: ShowRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoritesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FavoritesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}