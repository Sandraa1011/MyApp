package com.example.myapp.presentation.navigation

sealed class Screen(val route :String){
    data object Restaurant: Screen("Restaurante")


    data object Login:Screen("Login")


    data object Register:Screen("Register")


    data object AddRestaurant:Screen("Add")



}