package com.example.lista4podejscie2.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen (
    val route: String,
    val title: String,
    val icon: ImageVector
)
{
 object E1 : BottomBarScreen(
     route = "e1",
     title = "E1",
     icon = Icons.Default.MailOutline
 )

    object E2 : BottomBarScreen(
        route = "e2",
        title = "E2",
        icon = Icons.Default.Star
    )
    object E3 : BottomBarScreen(
        route = "e3",
        title = "E3",
        icon = Icons.Default.Send
    )
}