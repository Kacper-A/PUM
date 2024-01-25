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
import com.example.projekt_proba2.data.Item
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




    if(!viewModel.checkIfItemExists(2137))
    {

        var newItem = Item(
            id = 1, // id 1 set as default value for settings
            date = 2137, //set value to know where item is
            brekafast = 2000, //goal
            lunch = 1,//1 is max calorie, 0 is min calorie
            dinner =0 //unused
        )
        viewModel.addItem(newItem)

    }




    //
    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = "calendar") {
        composable("calendar") {
            CalendarComposable(viewModel,navController)
        }
        composable("todaysMeal") {

            
            todaysMealScreen(viewModel, 0,navController)
        }
        composable("specificDay/{date}"){ backStackEntry ->
            val date = backStackEntry.arguments?.getString("date")?.toLong()
            if (date != null) { //should not be called without date or will not work
                todaysMealScreen(viewModel, date,navController)
            }

        }

        composable("settings"){
            settings(viewModel, navController )
        }

    }



}