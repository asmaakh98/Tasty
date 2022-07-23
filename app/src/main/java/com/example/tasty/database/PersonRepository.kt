package com.example.tasty.database

import androidx.lifecycle.LiveData

class PersonRepository( private val personDao: PersonDao) {

    val readAllData: LiveData<List<Person>> =personDao.readAllData()

    suspend fun addPerson(person: Person){
        personDao.addPerson(person)
    }
    suspend fun deletePerson(){
        personDao.deleteAll()
    }
}