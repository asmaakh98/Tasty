package com.example.tasty.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PersonDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPerson(person: Person)

    @Query(value="SELECT * FROM person_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Person>>

    @Update
    suspend fun updatePerson(person: Person)


    @Query(value="DELETE FROM person_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM person_table WHERE fullName LIKE :searchQuery ")
    fun searchDatabase(searchQuery: String): LiveData<List<Person>>
}
