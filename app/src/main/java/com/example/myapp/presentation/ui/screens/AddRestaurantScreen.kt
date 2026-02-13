package com.example.myapp.presentation.ui.screens




import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myfirstapp.proyecto.presentation.ui.screens.MenuAcciones
import com.example.myfirstapp.proyecto.presentation.viewmodel.AddRestaurantScreenViewModel
import org.koin.androidx.compose.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddRestaurantScreen(navController: NavController,
                        addRestaurantScreenViewModel: AddRestaurantScreenViewModel = koinViewModel()
){
    val restaurant by addRestaurantScreenViewModel.restaurant.collectAsState()
    val snackbarHostState= remember { SnackbarHostState() }
    val colorFondo = Color(0xFFF1E2D3)
    val colorButton = Color(0xFFD37A56)


    Scaffold(
        snackbarHost={SnackbarHost(snackbarHostState)},

        containerColor = colorFondo,
        topBar = {

            MenuAcciones("Añadir restaurante", navController)

        }


    ) { innerPadding->
        Column(modifier=Modifier.padding(innerPadding)
            .fillMaxSize()) {
            TextField(modifier = Modifier.fillMaxWidth(),
                value = restaurant.name,
                onValueChange = {addRestaurantScreenViewModel.setName(it)},
                label = {Text("Nombre del restaurante")}
            )


            Spacer(modifier = Modifier.height(16.dp))


            TextField(
                modifier = Modifier.fillMaxWidth(),
                value =restaurant.type,
                onValueChange = {addRestaurantScreenViewModel.setType(it)},
                label = {Text("Tipo de comida")}
            )
            Spacer(modifier = Modifier.height(16.dp))


            TextField(
                modifier = Modifier.fillMaxWidth(),
                value=restaurant.point.toString(),
                onValueChange = {it.toDoubleOrNull()?.let{point->
                    addRestaurantScreenViewModel.setPoint(point)
                }},
                label = {"Puntuación (0-5)"}
            )
            Spacer(modifier = Modifier.height(16.dp))


            Row(modifier=Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically){
                Button(onClick = {
                    addRestaurantScreenViewModel.clear()
                    navController.popBackStack()
                },
                    colors = ButtonDefaults.buttonColors(containerColor = colorButton)
                ) {
                    Text("Cancelar")

                }

                Button(
                    onClick = {
                        addRestaurantScreenViewModel.save(navController, snackbarHostState )
                    }
                ) {
                    Text("Aceptar")
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewAddRestaurant(){
    AddRestaurantScreen(rememberNavController())
}
