package com.example.tasty.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class RecipeViewModel (application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Recipe>>
    private val repository: RecipeRepository

    init {
        val contactDao = RecipesDatabase.getDatabase(application).recipeDao()
        repository = RecipeRepository(contactDao)
        readAllData = repository.readAllData
    }

    fun addRecipe(recipe: Recipe){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addRecipe(recipe)
        }
    }
    fun deleteContact(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllRecipes()
        }
    }
    fun updateUser(recipe: Recipe){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateRecipe(recipe)
        }
    }
    fun searchDatabase(searchQuery: String): LiveData<List<Recipe>> {
        return repository.searchDatabase(searchQuery)
    }

}