package com.example.tasty.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RecipeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addRecipe(recipe: Recipe)

    @Query(value="SELECT * FROM recipe_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Recipe>>

    @Update
    suspend fun updateRecipe(recipe: Recipe)


    @Query(value="DELETE FROM recipe_table")
    suspend fun deleteAllRecipes()

    @Query("SELECT * FROM recipe_table WHERE recipeName LIKE :searchQuery ")
    fun searchDatabase(searchQuery: String): LiveData<List<Recipe>>
}