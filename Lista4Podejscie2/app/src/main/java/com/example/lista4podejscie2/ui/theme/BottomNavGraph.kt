package com.example.lista4podejscie2.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lista4podejscie2.ui.screens.E1
import com.example.lista4podejscie2.ui.screens.E2
import com.example.lista4podejscie2.ui.screens.E3

@Composable
fun BottomNavGraph(navController: NavHostController)
{
    NavHost(navController = navController, startDestination = BottomBarScreen.E1.route )
    {
        composable(route= BottomBarScreen.E1.route)
        {
            E1(navController)
        }
        composable(route= BottomBarScreen.E2.route)
        {
            E2()
        }
        composable("E3/{index}") { backStackEntry ->
            val index = backStackEntry.arguments?.getString("index")
            if (index != null) {
                E3(index)
            }
        }
    }
}