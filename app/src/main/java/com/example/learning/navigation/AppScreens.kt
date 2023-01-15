package com.example.learning.navigation

sealed class AppScreens(val route:String){
    object LoginScreen: AppScreens("login_screen")
    object FirstScreen: AppScreens("first_screen")
    object SecondScreen: AppScreens("second_screen")
}
