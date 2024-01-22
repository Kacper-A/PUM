package com.example.lista5.ui

import android.app.Application
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.compose.rememberNavController
import com.example.lista5.ui.screens.dodajNowy
import com.example.lista5.ui.screens.oceny

@Composable
fun Navigation() {

    val navController = rememberNavController()
dodajNowy(navController = navController)
//oceny(navController = navController)

}