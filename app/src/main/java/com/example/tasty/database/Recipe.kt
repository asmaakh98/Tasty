package com.example.tasty.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName="recipe_table")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val recipeName: String? = null,
    val category: String? = null,
    val time: String? = null,
    val ingredients: String? = null,
    val recipeImg: String? = null):Parcelable




