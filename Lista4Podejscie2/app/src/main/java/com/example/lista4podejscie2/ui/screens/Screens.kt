package com.example.lista4podejscie2.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens (
    val route: String,
    val icon: ImageVector
){

    object E1 : Screens("e1", Icons.Filled.MailOutline)
    object E2: Screens("e2", Icons.Filled.Star)
    object E3 : Screens("e3", Icons.Filled.ThumbUp)
}