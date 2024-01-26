package com.example.lista6

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.lista6.data.user

@Composable
fun detailProfile(data: user){


    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp)
            .background(Color.LightGray)
            .border(1.dp, Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(data.username)
        AsyncImage(model = data.avatar,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )


        Text(data.first_name + " "+ data.second_name)
        Text(data.gender)
        Text(data.date_of_birth)
        Text(data.address.city)
    }

}