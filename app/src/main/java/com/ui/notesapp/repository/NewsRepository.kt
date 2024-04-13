package com.ui.notesapp.repository

import android.content.Context
import androidx.annotation.WorkerThread
import com.ui.notesapp.room.AppDatabase
import com.ui.notesapp.room.Note
import com.ui.notesapp.room.NoteDao

class NotesRepository(
    val db: AppDatabase,
) {
    private val notesDao =db.NoteDao()
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getAllNotes() = notesDao.getAllNotes()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertNote(note: Note) = notesDao.insert(note)

}