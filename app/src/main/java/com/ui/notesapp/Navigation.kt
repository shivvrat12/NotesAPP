package com.ui.notesapp

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ui.notesapp.Screen.HomeScreen
import com.ui.notesapp.Screen.addItems
import com.ui.notesapp.ViewModel.NotesViewModel
import com.ui.notesapp.room.AppDatabase

@Composable
fun navigate() {
    val navController = rememberNavController()
    val viewModel: NotesViewModel = viewModel(factory = NotesViewModelFactory(appDatabase))
    NavHost(navController = navController, startDestination = "HomeScreen"){
        composable(route = "HomeScreen"){
            HomeScreen(navigateToSearchScreen = { navController.navigate("AddScreen") })
        }
        composable(route = "AddScreen"){
            addItems(viewModel = NotesViewModel())
        }
    }
}