package com.example.tasty.database

import android.location.Location
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName="person_table")
data class Person(
@PrimaryKey(autoGenerate = true)
val id: Int,
val fullName: String? = null,
val birthDate: String? = null,
val address: String? = null,
val telephone: String? = null,
val email: String? = null,
val personImg: String? = null):Parcelable
