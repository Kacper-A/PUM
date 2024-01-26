package com.example.lista6

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.lista6.data.user

@Composable
fun basicProfile(data: user, navController: NavHostController, id: Int) {

    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp)
            .background(Color.LightGray)
            .border(1.dp, Color.Black).clickable(onClick = {navController.navigate("detailProfile/${id}")}),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AsyncImage(model = data.avatar,
        contentDescription = null,
        contentScale = ContentScale.Crop,
            )


        //println(data.avatar)
        Text(data.username)
        Text(data.email)
    }
}