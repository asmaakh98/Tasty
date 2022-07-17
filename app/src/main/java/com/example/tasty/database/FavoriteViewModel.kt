package com.example.tasty.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoriteViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Favorite>>
    private val repository: FavoriteRepository

    init {
        val favoriteDao = FavoriteDatabase.getDatabase(application).favoriteDao()
        repository = FavoriteRepository(favoriteDao)
        readAllData = repository.readAllData
    }

    fun addFavorite(favorite: Favorite){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addFavorite(favorite)
        }
    }
    fun deleteFavorite(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteFavorite()
        }
    }

}