package com.example.tasty.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="favorite_table")
data class Favorite(
    @PrimaryKey
    val id: Int,
    val name: String,
    val category: String,
    val time: String,
    val ingredients: String,
    val img: String)
