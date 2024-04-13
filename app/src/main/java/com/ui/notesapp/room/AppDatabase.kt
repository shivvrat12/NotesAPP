package com.ui.notesapp.room

import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun NoteDao(): NoteDao

    private class NoteDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            Instance?.let { database ->
                scope.launch {
                    var noteDao = database.NoteDao()

                    // Delete all content here.
//                    noteDao.deleteAll()

                    // Add sample words.
                    var note = Note(title = "Hi", desciption = "hello")
                    noteDao.insert(note)
//                    word = Word("World!")
//                    wordDao.insert(word)
//
//                    // TODO: Add your own words!
//                    word = Word("TODO!")
//                    wordDao.insert(word)
                }
            }
        }
    }
    companion object{
        @Volatile
        private var Instance: AppDatabase? = null

        fun getDatabase(context: Context,scope: CoroutineScope):AppDatabase{
            return Instance?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "my_database.db"
                )
                    .addCallback(NoteDatabaseCallback(scope))
                    .build()
                Instance = instance
                instance
            }
        }


    }
}