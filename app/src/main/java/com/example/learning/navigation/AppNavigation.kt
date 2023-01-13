package com.example.learning.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.learning.Message
import com.example.learning.screens.FirstScreen
import com.example.learning.screens.SecondScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController , startDestination = AppScreens.FirstScreen.route){
        composable(route = AppScreens.FirstScreen.route){
            FirstScreen(navController)
        }

        composable(route = AppScreens.SecondScreen.route + "/{tittle}" + "/{body}",
        arguments = listOf(
            navArgument(name = "tittle") { type = NavType.StringType },
            navArgument(name = "body") { type = NavType.StringType }
        )
        ){
            val msg = Message(it.arguments?.getString("tittle").toString(),it.arguments?.getString("body").toString())
            SecondScreen(navController,msg)
        }
    }

}