package com.example.tasty.database

import androidx.lifecycle.LiveData

class   FavoriteRepository(private val favoriteDao: FavoriteDao) {

    val readAllData: LiveData<List<Favorite>> =favoriteDao.readAllData()

    suspend fun addFavorite(favorite: Favorite){
        favoriteDao.addFavorite(favorite)
    }
    suspend fun deleteFavorite(){
        favoriteDao.deleteContact()
    }
}