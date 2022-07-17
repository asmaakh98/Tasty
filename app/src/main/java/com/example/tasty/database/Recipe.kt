package com.example.tasty.database

import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName="recipe_table")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val recipeName: String? = null,
    val category: String? = null,
    val time: String? = null,
    val ingredients: String? = null,
    val recipeImg: String? = null){}




