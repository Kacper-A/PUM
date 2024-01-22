package com.example.projekt_proba2

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle

import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projekt_proba2.data.ItemViewModel
import com.example.projekt_proba2.data.ItemViewModelFactory
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date


@Composable
fun Navigation() {




    val viewModel: ItemViewModel = viewModel(
        LocalViewModelStoreOwner.current!!,
        "ItemViewModel",
        ItemViewModelFactory(LocalContext.current.applicationContext as Application)
    )

    //val items by    viewModel.usersState.collectAsStateWithLifecycle()

    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = "calendar") {
        composable("calendar") {
            CalendarComposable(navController)
        }
        composable("todaysMeal") {
            //val currentDate = java.util.Date.from(java.time.LocalDate.now().atStartOfDay(java.time.ZoneId.systemDefault()).toInstant())
            val currentDate = java.util.Date.from(
                LocalDate.now()
                    .atStartOfDay(ZoneId.systemDefault())
                    .toInstant()
            )

            val roundedDate = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()

            
            todaysMealScreen(viewModel, roundedDate)
        }
    }



}