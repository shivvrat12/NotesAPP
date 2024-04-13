package com.ui.notesapp



import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ui.notesapp.ViewModel.NotesViewModel
import com.ui.notesapp.repository.NotesRepository
import com.ui.notesapp.room.AppDatabase

class NotesViewModelFactory(private val newsRepository: NotesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NotesViewModel::class.java)) {
            return NotesViewModel(newsRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
