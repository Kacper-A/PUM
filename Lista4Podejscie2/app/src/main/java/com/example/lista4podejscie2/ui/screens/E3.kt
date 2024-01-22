package com.example.lista4podejscie2.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.lista4podejscie2.data.DataProvider

@Composable
fun E3(indexPassed: String)
{
    val indexPassedInt = indexPassed.toInt()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(text = "Moje Listy Zadań", modifier = Modifier.padding(10.dp).align(Alignment.CenterHorizontally))
        LazyColumn(
            modifier = Modifier.fillMaxWidth().height(600.dp)
        ) {
            items(DataProvider.listaZadan[indexPassedInt].exercise.size) { index ->
                Box(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .background(Color.Yellow)
                        .height(80.dp)

                ) {


                    // Text in the left upper corner
                    Text(
                        text = "Zadanie ${index}",
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(8.dp)
                    )

                    // Text in the right upper corner
                    Text(
                        text = "pkt ${DataProvider.listaZadan[indexPassedInt].exercise[index].points}",
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(8.dp)
                    )



                    // Text in the left down corner
                    Text(
                        text = "${DataProvider.listaZadan[indexPassedInt].exercise[index].content}",
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(8.dp)
                    )
                }
            }
        }



    }
}