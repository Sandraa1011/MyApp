package com.example.myapp.proyecto

import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.R

@Composable
fun Registro () {
    var text by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var password by remember { mutableStateOf("") }
    var repeatPassword by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    val options = listOf("Hombre", "Mujer")
    var selectedOption by remember { mutableStateOf(options[0]) }
    var number by remember{mutableStateOf(1)}
    val colorFondo = Color(0xFFF1E2D3)
    val colorButton = Color(0xFFD37A56)


    Scaffold(containerColor = colorFondo) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
                .padding(18.dp)
                .fillMaxSize(),

            ) {
            Row(
                modifier = Modifier.padding(18.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "Logo"
                )
            }
            Row {
                TextField(
                    value = text,
                    onValueChange = { newText -> text = newText },
                    label = { Text("Nombre de usuario") }

                )
            }
            Spacer(modifier = Modifier.height(14.dp))

            TextField(
                value = password,
                onValueChange = { newPassword -> password = newPassword },
                label = { Text("Contraseña") },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image =
                        if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, contentDescription = null)
                    }
                }
            )
            Spacer(modifier = Modifier.height(14.dp))

            TextField(
                value = repeatPassword,
                onValueChange = { newPassword -> repeatPassword = newPassword },
                label = { Text("Repite contraseña") },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image =
                        if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, contentDescription = null)
                    }
                }
            )

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                TextField(
                    modifier = Modifier.weight(0.5f),
                    value = name,
                    onValueChange = { newtext -> name = newtext },
                    label = { Text("Nombre") }
                )
                Spacer(modifier = Modifier.width(12.dp))

                TextField(
                    modifier = Modifier.weight(1f),
                    value = surname,
                    onValueChange = { newtext -> surname = newtext },
                    label = { Text("Apellidos") }
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            TextField(
                value = email,
                onValueChange = { newText -> email = newText },
                label = { Text("Email") }
            )

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                fontSize =18.sp,
                text= "Género"
            )
            Column {
                options.forEach { option ->
                    Row {
                        RadioButton(
                            selected = (option == selectedOption),
                            onClick = { selectedOption = option },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = colorButton,
                                unselectedColor = Color.Gray

                            )
                        )
                        Text(
                            text = option,
                            modifier = Modifier.clickable { selectedOption = option }
                        )
                    }
                }

            }
            Row(
                modifier = Modifier.padding(18.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { println("Botón presionado") },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorButton
                    ),

                    shape = RoundedCornerShape(50)
                ) {
                    Text("Aceptar")
                }
                Button(
                    onClick = { println("Botón presionado") },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorButton
                    ),

                    shape = RoundedCornerShape(50)
                ) {
                    Text("Cancelar")
                }
            }
        }
    }
}

@Preview
@Composable
fun previewRegistro(){
    Registro()
}