package com.atom.myapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.atom.myapp.uiapp.Home
import com.atom.myapp.uiapp.Detail

@Composable
fun Navigate(){
    val navController= rememberNavController()

    NavHost(
        navController=navController, startDestination = "Home"
    ){
        composable("Home"){
            Home(navController)
        }
        composable("Detail"){
            Detail(navController)
        }
    }
}