package com.ui.notesapp.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ui.notesapp.NotesType
import com.ui.notesapp.ViewModel.NotesViewModel


@Composable
fun HomeScreen( navigateToSearchScreen:()->Unit,viewModel: NotesViewModel = viewModel()){


    Column(Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween) {
        Column(
            modifier = Modifier
                .weight(1f, false)
        ) {
//            LazyRow() {
//                items(sampleList) { item ->
//                    CardView(item)
//                }
//            }
        }
            Button(
                onClick = { navigateToSearchScreen() }, modifier = Modifier
                    .padding(vertical = 2.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "ADD ITEMS")
        }
    }

}

@Composable
fun CardView(item: NotesType){
    Card {
        Column(modifier = Modifier.padding(4.dp)) {
            Text(text = "TITLE: ${item.title}")
            Text(text = "Desciption: ${item.description}")
        }
    }
}

