package com.example.myapp.proyecto.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.IconButton
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapp.domain.model.Restaurant
import com.example.myfirstapp.proyecto.presentation.navigation.Screen
import com.example.myfirstapp.proyecto.presentation.ui.screens.MenuAcciones

import com.example.myfirstapp.proyecto.presentation.viewmodel.RestaurantScreenViewModel
import org.koin.androidx.compose.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantScreen(navController: NavController,
                     restaurantScreenViewModel: RestaurantScreenViewModel = koinViewModel ()
){
    val restaurants by restaurantScreenViewModel.restaurants.collectAsState()

    val colorFondo = Color(0xFFF1E2D3)
    val colorButton = Color(0xFFD37A56)


    Scaffold (
        containerColor = colorFondo,

        topBar = {
            MenuAcciones("Restaurantes",navController)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {navController.navigate(Screen.AddRestaurant.route)},
                contentColor = colorButton
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Añadir"
                )
            }
        }
    ) {innerPadding->
        LazyColumn (modifier = Modifier.padding(innerPadding)
            .fillMaxSize()){
            items(restaurants){ restaurant->
                key (restaurants){
                    RestaurantCard(restaurant=restaurant,restaurantScreenViewModel=restaurantScreenViewModel,navController=navController)

                }


            }
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = colorButton
            ),
            onClick = {
                navController.popBackStack()
            }
        ) { Text("Atrás")}
    }
}


@Composable
fun RestaurantCard(restaurant: Restaurant, restaurantScreenViewModel: RestaurantScreenViewModel,navController: NavController){
    var expanded by remember{mutableStateOf(false)}
    var showDialog by remember { mutableStateOf(false) }
    val colorButton = Color(0xFFD37A56)

    if(showDialog){
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(text = "Eliminar un Restaurante") },
            text = { Text("¿Deseas eliminar el restaurante?") },
            confirmButton = {
                Button(onClick = {restaurantScreenViewModel.removeProduct(restaurant.id)
                    showDialog = false },
                    colors= ButtonDefaults.buttonColors(
                        containerColor=colorButton
                    )) {
                    Text("Aceptar")
                }
            },
            dismissButton = {
                Button(onClick = { showDialog = false },
                    colors= ButtonDefaults.buttonColors(
                        containerColor=colorButton
                    )) {
                    Text("Cancelar")
                }
            }
        )
    }
    Card(
        modifier=Modifier.fillMaxWidth(),
        onClick = {expanded=!expanded}
    ){
        Column {
            if(!expanded){
                Row (verticalAlignment = Alignment.CenterVertically){
                    Icon(
                        imageVector = Icons.Default.ExpandMore,
                        contentDescription = "Expandir"
                    )
                    Text(restaurant.name)
                }
            }else{
                Row (verticalAlignment = Alignment.CenterVertically){
                    Icon(
                        imageVector = Icons.Default.ExpandLess,
                        contentDescription = "Contraer"
                    )
                    Text(restaurant.name)
                }
                Spacer(modifier=Modifier.height(16.dp))

                Text("Tipo: ${restaurant.type}")

                Spacer(modifier=Modifier.height(16.dp))

                Text("Puntos: ${restaurant.point.toString()}")

                Row(modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically){

                    Spacer(modifier= Modifier.weight(1f))
                    IconButton(onClick = {showDialog=true}) {
                        Icon(
                            tint = colorButton,
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Eliminar"
                        )
                    }
                    IconButton(onClick = {navController.navigate(Screen.Update.createRoute(restaurant.id)) }) {
                        Icon(
                            tint = colorButton,
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Editar"
                        )
                    }
                }

            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewRestaurantScreen(){
    RestaurantScreen(rememberNavController())
}