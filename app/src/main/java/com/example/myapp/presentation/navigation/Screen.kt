package com.example.myfirstapp.proyecto.presentation.navigation

sealed class Screen(val route :String){
    data object Restaurant: Screen("Página principal")

    data object Login:Screen("Login")

    data object Register:Screen("Registro")

    data object AddRestaurant:Screen("Añadir")

    data object MenuAcciones:Screen("Menú de acciones")

    data object UpdateRestaurant: Screen("Update")


}

