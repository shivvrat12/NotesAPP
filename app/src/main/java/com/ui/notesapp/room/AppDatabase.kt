package com.ui.notesapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun NoteDao(): NoteDao
    companion object{
        @Volatile
        private var Instance: AppDatabase? = null

        fun getDatabase(context: Context):AppDatabase{
            return Instance?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "my_database"
                ).build()
                Instance = instance
                instance
            }
        }
    }
}