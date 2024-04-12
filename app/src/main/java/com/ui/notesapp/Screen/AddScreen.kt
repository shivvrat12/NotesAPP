package com.ui.notesapp.Screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ui.notesapp.NotesType
import com.ui.notesapp.ViewModel.NotesViewModel

@Composable
 fun addItems(modifier: Modifier = Modifier.fillMaxSize(),viewModel: NotesViewModel){

     var Title by remember {
         mutableStateOf("")
     }
    var Desciption by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
         TextField(value = Title, onValueChange = {
             Title = it
         }, label = { Text(text = "Enter Title")})
        Spacer(
            modifier = Modifier.padding(10.dp))
        TextField(value = Desciption, onValueChange = {
            Desciption = it
        }, label = { Text(text = "Enter Description")})
        Spacer(
            modifier = Modifier.padding(5.dp))
        Button(onClick = { viewModel.insertNote(Title,Desciption) }, modifier = Modifier.align(Alignment.CenterHorizontally))
        {
            Text(text = "Add Items")
        }
     }
 }
