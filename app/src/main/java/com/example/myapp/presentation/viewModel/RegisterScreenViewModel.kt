package com.example.myfirstapp.proyecto.presentation.viewmodel


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class RegistroScreenViewModel : ViewModel () {


    private val _text= MutableStateFlow("")
    val text: StateFlow<String> = _text

    // Estados de los campos
    private val _username = MutableStateFlow("")
    val username:  StateFlow<String> = _username


    private val _password = MutableStateFlow("")
    val password : StateFlow<String> = _password


    private val _repeatPassword = MutableStateFlow("")
    val repeatPassword :  StateFlow<String> = _repeatPassword


    private val _name = MutableStateFlow("")
    val name :  StateFlow<String> = _name


    private val _surname = MutableStateFlow("")
    val surname :  StateFlow<String> = _surname




    private val _email = MutableStateFlow("")
    val email:  StateFlow<String> = _email


    private val _selectedOption = MutableStateFlow("Hombre")
    val selectedOption : StateFlow<String> = _selectedOption


    private val _passwordVisible = MutableStateFlow(false)
    val passwordVisible : StateFlow<Boolean> = _passwordVisible
    fun setUsername(username: String) {
        _username.value = username
    }


    fun setPassword(password: String) {
        _password.value = password
    }


    fun setRepeatPassword(password: String) {
        _repeatPassword.value = password
    }


    fun setPasswordVisible() {
        _passwordVisible.value = !_passwordVisible.value
    }


    fun setName(name: String) {
        _name.value = name
    }


    fun setSurname(surname: String) {
        _surname.value = surname
    }


    fun setEmail(email: String) {
        _email.value = email
    }


    fun setSelectedOption(option: String) {
        _selectedOption.value = option
    }


    // Función para limpiar el formulario (útil para el botón Cancelar)
    fun clear() {
        _username.value = ""
        _password.value = ""
        _repeatPassword.value = ""
        _passwordVisible.value = false
        _name.value = ""
        _surname.value = ""
        _email.value = ""
        _selectedOption.value = "Hombre"
    }




}
