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
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapp.presentation.viewModel.UpdateScreenViewModel
import com.example.myfirstapp.proyecto.presentation.ui.screens.MenuAcciones
import org.koin.androidx.compose.koinViewModel
import kotlin.toString


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateRestaurantScreen(navController: NavController, id: String, updateScreenViewModel: UpdateScreenViewModel= koinViewModel ()) {

    updateScreenViewModel.setId(id)
    val restaurant by updateScreenViewModel.restaurant.collectAsState();
    val snackbarHostState = remember { SnackbarHostState() }

    val colorFondo = Color(0xFFF1E2D3)
    val colorButton = Color(0xFFD37A56)
    Scaffold (
        containerColor = colorFondo,
        topBar = {
            MenuAcciones("Actualizar Restaurante", navController)
        }
    ) { innerPadding->
        Column (modifier = Modifier.padding(innerPadding).fillMaxSize()){
            Text(
                text = "Update Screen for Id: $id",
                style=MaterialTheme.typography.headlineMedium
            )
            Spacer(Modifier.height(8.dp))
            TextField(
                modifier= Modifier.fillMaxWidth(),
                value = restaurant.name,
                onValueChange = {updateScreenViewModel.setName(it)},
                label = {Text("Nombre")}
            )
            Spacer(Modifier.height(8.dp))
            TextField(
                modifier= Modifier.fillMaxWidth(),
                value = restaurant.type,
                onValueChange = {updateScreenViewModel.setType(it)},
                label = {Text("Tipo")}
            )
            Spacer(Modifier.height(8.dp))
            TextField(
                modifier= Modifier.fillMaxWidth(),
                value = restaurant.point.toString(),
                onValueChange = {it.toDoubleOrNull()?.let{point->
                    updateScreenViewModel.setPoint(point)
                }},
                label = {Text("Puntos")}
            )

            Row {
                Button(
                    onClick = {navController.popBackStack()},
                    colors= ButtonDefaults.buttonColors(
                        containerColor=colorButton
                    ),
                ) {
                    Text("Volver")
                }
                Button(onClick = {
                    updateScreenViewModel.update(navController,snackbarHostState)
                },
                    colors= ButtonDefaults.buttonColors(
                        containerColor=colorButton
                    ),
                ) {
                    Text("Aceptar")
                }
            }

        }
    }

}

@Composable
@Preview
fun PreviewUpdateScreen(){
    UpdateRestaurantScreen(rememberNavController(),"9234023")
}