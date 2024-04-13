package com.ui.notesapp

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.ui.notesapp.Screen.HomeScreen
import com.ui.notesapp.Screen.addItems
import com.ui.notesapp.ViewModel.NotesViewModel
import com.ui.notesapp.room.AppDatabase

@Composable
fun navigate(context: Context,viewModel:NotesViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "HomeScreen"){
        composable(route = "HomeScreen"){
            HomeScreen(navigateToSearchScreen = { navController.navigate("AddScreen") },viewModel)
        }
        composable(route = "AddScreen"){
            addItems(viewModel = viewModel, navController = navController)
        }
    }
}