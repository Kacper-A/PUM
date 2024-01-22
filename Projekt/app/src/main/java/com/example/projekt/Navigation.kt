package com.example.projekt

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projekt.data.ItemViewModel


@Composable
fun Navigation() {



    val navController = rememberNavController()

    //val itemViewModel =  hiltViewModel() //this line couses CRASH

    NavHost(navController = navController, startDestination = "calendar") {
        composable("calendar") {
            CalendarComposable(navController)
        }
        composable("todaysMeal") {
            todaysMealScreen()
        }
    }



}