package com.ui.notesapp

import android.app.Application
import com.ui.notesapp.repository.NotesRepository
import com.ui.notesapp.room.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class NotesApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { AppDatabase.getDatabase(this,applicationScope) }
    val repository by lazy { NotesRepository(database) }
}