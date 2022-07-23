package com.example.tasty.database

import android.location.Location
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName="person_table")
data class Person(
@PrimaryKey(autoGenerate = true)
val id: Int,
val fullName: String? = null,
val birthDate: String? = null,
val location: String? = null,
val telephone: String? = null,
val email: String? = null,
val personImg: String? = null)
