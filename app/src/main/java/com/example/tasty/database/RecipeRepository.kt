package com.example.tasty.database

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

class RecipeRepository (private val recipeDao: RecipeDao) {

    val readAllData: LiveData<List<Recipe>> =recipeDao.readAllData()

    suspend fun addRecipe(recipe: Recipe){
        recipeDao.addRecipe(recipe)
    }
    suspend fun deleteAllRecipes(){
        recipeDao.deleteAllRecipes()
    }
    suspend fun updateRecipe(recipe:Recipe){
        recipeDao.updateRecipe(recipe)
    }
    fun searchDatabase(searchQuery: String): LiveData<List<Recipe>> {
        return recipeDao.searchDatabase(searchQuery)
    }
}