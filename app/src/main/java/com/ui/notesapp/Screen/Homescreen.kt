package com.ui.notesapp.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.absolutePadding
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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ui.notesapp.NotesType
import com.ui.notesapp.R
import com.ui.notesapp.ViewModel.NotesViewModel
import com.ui.notesapp.room.Note


@Composable
fun HomeScreen( navigateToSearchScreen:()->Unit,viewModel: NotesViewModel){


    Column(Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween) {
        Column(
//            modifier = Modifier
//                .fillMaxWidth()
        ) {
            LazyColumn() {
                items(viewModel.notes) { item ->
                    CardView(item)
                }
            }
        }
            FloatingActionButton(
                onClick = { navigateToSearchScreen() }, modifier = Modifier
                    .padding(bottom = 15.dp, end = 15.dp)

                    .align(alignment = Alignment.End)

            ) {
                Icon(painter = painterResource(R.drawable.baseline_add_24),"add")
        }
    }

}

@Composable
fun CardView(item: Note){
    Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Column(modifier = Modifier.padding(4.dp)) {
            Text(modifier = Modifier.padding(3.dp),text = item.title, fontWeight = FontWeight.Bold,)
            Text(modifier = Modifier.padding( 2.dp),text = item.desciption)
        }
    }
}

