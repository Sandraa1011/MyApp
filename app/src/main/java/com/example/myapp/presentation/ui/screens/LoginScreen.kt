import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.myapp.R
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myfirstapp.proyecto.presentation.navigation.Screen

import com.example.myfirstapp.proyecto.presentation.viewmodel.LoginScreenViewModel


@Composable
fun LoginScreen(navController: NavController,
                loginScreenViewModel: LoginScreenViewModel = viewModel()){
    val username by loginScreenViewModel.username.collectAsState()
    val password by loginScreenViewModel.password.collectAsState()
    val passwordVisible by loginScreenViewModel.passwordVisible.collectAsState()
    val loginEnabled by remember{
        derivedStateOf {
            username.isNotBlank()&& password.isNotBlank()
        }
    }
    val colorFondo = Color(0xFFF1E2D3)
    val colorBoton=Color(0xFFD37A56)
    val colorText=Color(0xFF3C3C3C)


    Scaffold (containerColor = colorFondo) { innerPadding->
        Column(modifier = Modifier.padding(innerPadding)
            .fillMaxSize(),
            horizontalAlignment=Alignment.CenterHorizontally,


            ){
            Row (modifier = Modifier.padding(18.dp)
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center){
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(id= R.drawable.img),
                    contentDescription= "Logo"
                ) }
            Row (modifier=Modifier.padding(18.dp)){
                TextField(
                    modifier= Modifier.background(colorText),
                    value=username,
                    onValueChange = {loginScreenViewModel.setUsername(it)},
                    label={Text("Nombre de usuario")}




                )
            }
            Row (modifier=Modifier.padding(18.dp)){
                TextField(
                    modifier= Modifier.background(colorText),
                    value = password,
                    onValueChange = { loginScreenViewModel.setPassword(it) },
                    label = { Text("Contraseña") },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon={
                        val image= if(passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                        IconButton(onClick={loginScreenViewModel.setPasswordVisible()}){
                            Icon(imageVector=image,contentDescription=null)
                        }
                    }
                )


            }
            Row (modifier=Modifier.padding(18.dp),
                horizontalArrangement = Arrangement.SpaceBetween){
                Button(onClick={navController.navigate(Screen.Restaurant.route) },
                    colors= ButtonDefaults.buttonColors(
                        containerColor=colorBoton
                    ),
                    shape=RoundedCornerShape(50)){
                    Text("Aceptar")
                }
                Button(
                    onClick={ loginScreenViewModel.clear()},
                    colors= ButtonDefaults.buttonColors(
                        containerColor=colorBoton
                    ),
                    shape=RoundedCornerShape(50)){
                    Text("Limpiar")
                }
                Button(onClick={navController.navigate(Screen.Register.route)},
                    colors= ButtonDefaults.buttonColors(
                        containerColor=colorBoton
                    ),
                    shape=RoundedCornerShape(50)){
                    Text("Registrarse")
                    Spacer(modifier=Modifier.width(8.dp))
                }
            }


        }
    }
}


@Preview
@Composable
fun previewLogin(){
    LoginScreen(rememberNavController())
}
