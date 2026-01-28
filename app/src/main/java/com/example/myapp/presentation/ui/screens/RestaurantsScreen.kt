package com.example.myfirstapp.proyecto.presentation.ui.screens


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
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.IconButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


import androidx.compose.ui.unit.dp
import com.example.myapp.presentation.ui.components.MenuAcciones
import com.example.myapp.presentation.navigation.Screen
import com.example.myfirstapp.proyecto.presentation.viewmodel.RestaurantScreenViewModel
import kotlin.coroutines.coroutineContext


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantScreen(navController: NavController,
                     restaurantScreenViewModel: RestaurantScreenViewModel= viewModel()){
    val restaurantCards by restaurantScreenViewModel.restaurantCards.collectAsState()


    Scaffold (
        topBar = {
            MenuAcciones("Restaurantes",navController)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {navController.navigate(Screen.AddRestaurant.route)}) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Añadir"
                )
            }
        }
    ) {innerPadding->
        LazyColumn (modifier = Modifier.padding(innerPadding)
            .fillMaxSize()){
            items(restaurantCards, key = {it.restaurant.id}){restaurantCard->
                Card(modifier = Modifier.fillMaxWidth()
                    .padding(8.dp),
                    onClick = {restaurantScreenViewModel.selected(restaurantCard.restaurant.id)})
                {
                    Row (verticalAlignment = Alignment.CenterVertically){
                        if(restaurantCard.expanded){
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = "Expandido",
                                modifier= Modifier.align (Alignment.Top)
                            )
                            Column {
                                Text(restaurantCard.restaurant.name)
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("Tipo: ${restaurantCard.restaurant.type}")
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("Puntos: ${restaurantCard.restaurant.point}")



                            }
                        }else{
                            Row (verticalAlignment = Alignment.CenterVertically){
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowUp,
                                    contentDescription = "Contraido"


                                )
                                Text(restaurantCard.restaurant.name)
                            }
                        }
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
