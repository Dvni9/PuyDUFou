package com.example.puydufou.ui.shows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.puydufou.data.repository.ShowRepository
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModelProvider


class ShowsViewModel(private val repository: ShowRepository) : ViewModel() {

    val shows = repository.allShows.asLiveData()

    fun initializeData() {
        viewModelScope.launch {
            repository.initializeDatabase()
        }
    }

    fun toggleFavorite(showId: Int, isFavorite: Boolean) {
        viewModelScope.launch {
            repository.toggleFavorite(showId, isFavorite)
        }
    }
}


class ShowsViewModelFactory(
    private val repository: ShowRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShowsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ShowsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}