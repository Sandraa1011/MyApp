package com.example.myfirstapp.proyecto.presentation.viewmodel


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class LoginScreenViewModel : ViewModel() {


    private val _username= MutableStateFlow("")
    val username: StateFlow<String> =_username


    private val _password= MutableStateFlow("")
    val password: StateFlow<String> = _password


    private val _passwordVisible = MutableStateFlow(false)
    val passwordVisible : StateFlow<Boolean> = _passwordVisible


    fun setUsername(username: String){
        _username.value=username
    }


    fun setPassword(password: String){
        _password.value= password
    }


    fun setPasswordVisible(){
        _passwordVisible.value= !_passwordVisible.value
    }


    fun clear(){
        _username.value=""
        _password.value=""
        _passwordVisible.value=false
    }


}
