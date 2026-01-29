package com.example.myapp.proyecto.presentation.navigation

import LoginScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapp.presentation.ui.screens.AddRestaurantScreen
import com.example.myapp.presentation.ui.screens.UpdateRestaurantScreen
import com.example.myapp.proyecto.presentation.ui.screens.RestaurantScreen
import com.example.myfirstapp.proyecto.presentation.navigation.Screen
import com.example.myfirstapp.proyecto.presentation.ui.screens.RegisterScreen



@Composable
fun NavGraph(startDestination: String = Screen.Login.route) {
    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = startDestination) {
        composable(Screen.Restaurant.route) {
            RestaurantScreen(navController)
        }
        composable(Screen.Login.route) {
            LoginScreen(navController)
        }
        composable(Screen.Register.route) {
            RegisterScreen(navController)
        }
        composable(Screen.AddRestaurant.route) {
            AddRestaurantScreen(navController)
        }
        composable(Screen.UpdateRestaurant.route) {
            UpdateRestaurantScreen(navController)
        }


    }
}

@Preview(showBackground = true)
@Composable
fun NavGraphPreview() {
    NavGraph()
}