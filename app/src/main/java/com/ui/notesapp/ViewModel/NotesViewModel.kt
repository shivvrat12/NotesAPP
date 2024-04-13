package com.ui.notesapp.ViewModel

import android.icu.text.CaseMap.Title
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ui.notesapp.NotesType
import com.ui.notesapp.repository.NotesRepository
import com.ui.notesapp.room.AppDatabase
import com.ui.notesapp.room.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NotesViewModel(private val notesRepository: NotesRepository): ViewModel() {

     val notes = mutableListOf<Note>()
     fun insertNote(title: String, description: String){
        viewModelScope.launch(Dispatchers.IO) {
            val note = Note(title=title, desciption = description)
            notesRepository.insertNote(note)
            getAllNotes()
        }
    }

private fun getAllNotes(){
    viewModelScope.launch(Dispatchers.IO) {
        val noteList=fetchAllNotes()
        notes.addAll(noteList)
    }
}


    init {
        getAllNotes()
    }
     private suspend fun fetchAllNotes():List<Note>{

          return notesRepository.getAllNotes()

    }


}
