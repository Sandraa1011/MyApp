package com.example.myapp.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun UpdateRestaurantScreen(navController: NavController) {
    val colorFondo = Color(0xFFF1E2D3)
    val colorButton = Color(0xFFD37A56)
    Scaffold (
        containerColor = colorFondo
    ){ innerPadding->
        Column (modifier = Modifier.padding(innerPadding).fillMaxSize()){
            Button(
                colors= ButtonDefaults.buttonColors(
                containerColor=colorButton
            ),
                onClick = {navController.popBackStack()}
            ) {
                Text("Volver")
            }
        }
    }
}

@Composable
@Preview
fun PreviewUpdateScreen(){
    UpdateRestaurantScreen(rememberNavController())
}