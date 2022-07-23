package com.example.tasty.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Person::class], version = 1, exportSchema = false)
abstract class PersonDatabase : RoomDatabase() {

    abstract fun personDao(): PersonDao

    companion object{
        @Volatile
        private var INSTANCE: PersonDatabase? = null

        fun getDatabase(context: Context):PersonDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(lock = this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    PersonDatabase::class.java,
                    "favorite_database"
                ).build()
                INSTANCE=instance
                return instance
            }
        }
    }

}