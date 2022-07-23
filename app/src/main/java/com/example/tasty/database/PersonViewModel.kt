package com.example.tasty.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonViewModel (application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Person>>
    private val repository: PersonRepository

    init {
        val personDao = PersonDatabase.getDatabase(application).personDao()
        repository = PersonRepository(personDao)
        readAllData = repository.readAllData
    }

    fun addPerson(person: Person){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addPerson(person)
        }
    }
    fun deleteperson(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletePerson()
        }
    }

}