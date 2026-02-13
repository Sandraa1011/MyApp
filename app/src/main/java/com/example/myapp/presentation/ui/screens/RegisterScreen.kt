package com.example.myfirstapp.proyecto.presentation.ui.screens


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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapp.R
import com.example.myfirstapp.proyecto.presentation.navigation.Screen


import com.example.myfirstapp.proyecto.presentation.viewmodel.RegistroScreenViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun RegisterScreen (navController: NavController,
                    registroScreenViewModel: RegistroScreenViewModel = koinViewModel ()
) {
    val username by registroScreenViewModel.username.collectAsState()
    val password by registroScreenViewModel.password.collectAsState()
    val repeatPassword by registroScreenViewModel.repeatPassword.collectAsState()
    val name by registroScreenViewModel.name.collectAsState()
    val surname by registroScreenViewModel.surname.collectAsState()
    val email by registroScreenViewModel.email.collectAsState()
    val selectedOption by registroScreenViewModel.selectedOption.collectAsState()
    val passwordVisible by registroScreenViewModel.passwordVisible.collectAsState()


    val options = listOf("Hombre", "Mujer")
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
                    value = username,
                    onValueChange = { registroScreenViewModel.setUsername(it) },
                    label = { Text("Nombre de usuario") }


                )
            }
            Spacer(modifier = Modifier.height(14.dp))


            TextField(
                value = password,
                onValueChange = {registroScreenViewModel.setPassword(it) },
                label = { Text("Contraseña") },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image =
                        if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                    IconButton(onClick = { registroScreenViewModel.setPasswordVisible() }) {
                        Icon(imageVector = image, contentDescription = null)
                    }
                }
            )
            Spacer(modifier = Modifier.height(14.dp))


            TextField(
                value = repeatPassword,
                onValueChange = { registroScreenViewModel.setRepeatPassword(it) },
                label = { Text("Repite contraseña") },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image =
                        if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                    IconButton(onClick = { registroScreenViewModel.setPasswordVisible() }) {
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
                    onValueChange = { registroScreenViewModel.setName(it) },
                    label = { Text("Nombre") }
                )
                Spacer(modifier = Modifier.width(12.dp))


                TextField(
                    modifier = Modifier.weight(1f),
                    value = surname,
                    onValueChange = { registroScreenViewModel.setSurname(it) },
                    label = { Text("Apellidos") }
                )
            }


            Spacer(modifier = Modifier.height(14.dp))


            TextField(
                value = email,
                onValueChange = { registroScreenViewModel.setEmail(it) },
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
                            onClick = { registroScreenViewModel.setSelectedOption(option) },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = colorButton,
                                unselectedColor = Color.Gray


                            )
                        )
                        Text(
                            text = option,
                            modifier = Modifier.clickable { registroScreenViewModel.setSelectedOption(option) }
                        )
                    }
                }


            }
            Row(
                modifier = Modifier.padding(18.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { navController.navigate(Screen.Restaurant.route) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorButton
                    ),


                    shape = RoundedCornerShape(50)
                ) {
                    Text("Aceptar")
                }
                Button(
                    onClick = { navController.navigate(Screen.Login.route) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorButton
                    ),


                    shape = RoundedCornerShape(50)
                ) {
                    Text("Volver")
                }
            }
        }
    }
}


@Preview
@Composable
fun previewRegistro(){
    RegisterScreen(rememberNavController())
}
