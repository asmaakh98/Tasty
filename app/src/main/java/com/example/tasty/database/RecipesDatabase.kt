package com.example.tasty.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Recipe::class], version = 1, exportSchema = false)

public abstract class RecipesDatabase : RoomDatabase(){


    abstract fun recipeDao(): RecipeDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: RecipesDatabase? = null

        fun getDatabase(context: Context): RecipesDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(lock = this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    RecipesDatabase::class.java,
                    "contact_database"
                ).build()
                INSTANCE=instance
                return instance
            }
        }
    }

}