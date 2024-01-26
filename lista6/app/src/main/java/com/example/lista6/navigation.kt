package com.example.lista6

import android.annotation.SuppressLint
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lista6.data.RetrofitInstance
import com.example.lista6.data.user
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun navigation() {

    var data by remember { mutableStateOf<List<user>>(emptyList()) }
    var loading by remember { mutableStateOf(true) }

    val job = GlobalScope.launch(Dispatchers.Main) {
        data = RetrofitInstance.api.getData()
        loading = false
    }



    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "mainScreen") {
        composable("mainScreen")
        {
            if (loading) {
                // You can show a loading indicator here

                Text(text = "Loading...")
            } else {
                mainScreen(data,navController)
                //println("adress: "+data[0].address.city)
            }
        }

        composable("detailProfile/{index}")
        { backStackEntry ->

            if (loading) {
                // You can show a loading indicator here

                Text(text = "Loading...")
            } else {
                detailProfile(data = data[backStackEntry.arguments?.getString("index")?.toInt()!!])
            }
        }

    }
}

