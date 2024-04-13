package com.ui.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.ui.notesapp.Screen.HomeScreen
import com.ui.notesapp.ViewModel.NotesViewModel
import com.ui.notesapp.repository.NotesRepository
import com.ui.notesapp.room.AppDatabase
import com.ui.notesapp.ui.theme.NotesAPPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
         val notesViewModel: NotesViewModel by viewModels {
            NotesViewModelFactory((application as NotesApplication).repository)
        }
        super.onCreate(savedInstanceState)
        setContent {
            NotesAPPTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    HomeScreen(navigateToSearchScreen = { /*TODO*/ })
                    navigate(this,notesViewModel)
                }
            }
        }
    }
    
    
}

