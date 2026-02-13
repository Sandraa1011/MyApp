package com.example.myapp.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapp.presentation.viewModel.UpdateScreenViewModel
import org.koin.androidx.compose.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateRestaurantScreen(navController: NavController, id: String, updateScreenViewModel: UpdateScreenViewModel= koinViewModel ()) {

    val restaurant by updateScreenViewModel.restaurant.collectAsState();
    val snackbarHostState = remember { SnackbarHostState() }

    val colorFondo = Color(0xFFF1E2D3)
    val colorButton = Color(0xFFD37A56)
    Scaffold (
        containerColor = colorFondo,
        topBar = {
            TopAppBar(
                title = {Text("Pantalla de actualización")}
            )
        }
    ) { innerPadding->
        Column (modifier = Modifier.padding(innerPadding).fillMaxSize()){
            Text(
                text = "Update Screen for Id: $id",
                style=MaterialTheme.typography.headlineMedium
            )
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
            }) {
                Text("Aceptar")
            }
        }
    }

}

@Composable
@Preview
fun PreviewUpdateScreen(){
    UpdateRestaurantScreen(rememberNavController(),"9234023")
}