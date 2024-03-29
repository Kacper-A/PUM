package com.example.lista4podejscie2

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lista4podejscie2.ui.screens.E1
import com.example.lista4podejscie2.ui.screens.E2
import com.example.lista4podejscie2.ui.screens.E3
import com.example.lista4podejscie2.ui.screens.Screens
import com.example.lista4podejscie2.ui.theme.BottomBarScreen
import com.example.lista4podejscie2.ui.theme.BottomNavGraph
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material3.Text
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation() {

    val navController = rememberNavController()

    /*
    val screens = listOf(Screens.E1,Screens.E2,Screens.E3)

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val currentScreen =
        screens.find { it.route == currentDestination?.route } ?: Screens.E1

*/
    Scaffold (
        bottomBar = { BottomBar(navController = navController)}
    ){
        BottomNavGraph(navController = navController)
    }


}
@Composable
fun BottomBar(navController: NavHostController)
{
    val screens = listOf(
        BottomBarScreen.E1,
        BottomBarScreen.E2
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(){
        screens.forEach {
            screen ->AddItem(screen = screen, currentDestination = currentDestination, navController = navController)
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
)
{
    BottomNavigationItem(
        label = { Text(text = screen.title)},
        icon = {
            Icon(imageVector = screen.icon, contentDescription = "Navigation Icon")
        },
        selected = currentDestination?.hierarchy?.any
        {
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route)
            {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )

}
