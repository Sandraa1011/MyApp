package com.example.myfirstapp.proyecto.presentation.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.myfirstapp.proyecto.presentation.navigation.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuAcciones(title:String,navController: NavController){
    var expanded by remember{ mutableStateOf(false) }

    TopAppBar(
        title={Text(text = title)},
        actions = {
            IconButton(onClick = {expanded=true}) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menú"
                )
            }
            DropdownMenu(
                expanded=expanded,
                onDismissRequest = {expanded=false }
            ) {
                DropdownMenuItem(
                    text={Text("Login")},
                    onClick = {
                        expanded=false
                        navController.navigate(Screen.Login.route)
                    }
                )
                DropdownMenuItem(
                    text={Text("Página principal")},
                    onClick = {
                        expanded=false
                        navController.navigate(Screen.Restaurant.route)
                    }
                )
                DropdownMenuItem(
                    text={Text("Atrás")},
                    onClick = {
                        expanded=false
                        navController.popBackStack()
                    }
                )
                HorizontalDivider()
                DropdownMenuItem(
                    text = {
                        Text("Other action")
                    },
                    onClick = {navController.navigate(Screen.AddRestaurant.route)
                        // Simplemente cierra el menú desplegable
                        expanded = false
                    }
                )

            }
        })
}
