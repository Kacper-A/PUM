package com.example.lista4podejscie2.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.lista4podejscie2.data.DataProvider

@Composable
fun E1(navController: NavHostController)
{
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(text = "Moje Listy Zadań", modifier = Modifier.padding(10.dp).align(Alignment.CenterHorizontally))
        LazyColumn(
            modifier = Modifier.fillMaxWidth().height(600.dp)
        ) {
            items(DataProvider.listaZadan.size) { index ->
                Box(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .background(Color.Yellow)
                        .height(80.dp).clickable {
                            navController.navigate("E3/$index")






                        }



                ) {
                    val localIndex = remember(index) { index }

                    // Text in the left upper corner
                    Text(
                        text = DataProvider.listaZadan[localIndex].subject.name,
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(8.dp)
                    )

                    // Text in the right upper corner
                    Text(
                        text = "Lista ${DataProvider.listaZadan[localIndex].indexOfExercise}",
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(8.dp)
                    )

                    // Text in the right down corner
                    Text(
                        text = "Ocena: ${DataProvider.listaZadan[localIndex].grade}",
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(8.dp)
                    )

                    // Text in the left down corner
                    Text(
                        text = "Liczba zadań: ${DataProvider.listaZadan[localIndex].exercise.size}",
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(8.dp)
                    )
                }
            }
        }



    }
}
