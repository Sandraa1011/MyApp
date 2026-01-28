package com.example.myapp.presentation.navigation

import LoginScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapp.presentation.ui.components.MenuAcciones
import com.example.myapp.presentation.ui.screens.AddRestaurantScreen
import com.example.myapp.presentation.navigation.Screen
import com.example.myfirstapp.proyecto.presentation.ui.screens.RegisterScreen
import com.example.myfirstapp.proyecto.presentation.ui.screens.RestaurantScreen


@Composable
fun NavGraph(startDestination: String = Screen.Login.route){
    val navController= rememberNavController()

    NavHost(navController=navController, startDestination=startDestination){
        composable(Screen.Restaurant.route){
            RestaurantScreen(navController)
        }
        composable(Screen.Login.route){
            LoginScreen(navController)
        }
        composable(Screen.Register.route) {
            RegisterScreen(navController)
        }
        composable(Screen.AddRestaurant.route) {
            AddRestaurantScreen(navController)
        }


    }
}

@Preview(showBackground = true)
@Composable
fun NavGraphPreview() {
    NavGraph()
}
