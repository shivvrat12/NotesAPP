package com.ui.notesapp.ViewModel

import android.icu.text.CaseMap.Title
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ui.notesapp.NotesType
import com.ui.notesapp.room.AppDatabase
import com.ui.notesapp.room.Note
import kotlinx.coroutines.launch

class NotesViewModel(private val database: AppDatabase): ViewModel() {

    private val noteDao = database.NoteDao()

    fun insertNote(title: String, description: String){
        viewModelScope.launch {
            val note = Note(title=title, desciption = description)
            noteDao.insert(note)
        }
    }
}
