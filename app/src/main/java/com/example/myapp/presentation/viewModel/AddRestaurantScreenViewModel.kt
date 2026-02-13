package com.example.myfirstapp.proyecto.presentation.viewmodel

import androidx.compose.material3.SnackbarHostState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapp.domain.model.Restaurant
import com.example.myapp.domain.usecase.AddRestaurantUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AddRestaurantScreenViewModel(val addRestaurantUseCase: AddRestaurantUseCase) : ViewModel() {


    private val _restaurant = MutableStateFlow(
        Restaurant("", "", "", 0.0)
    )
    val restaurant: StateFlow<Restaurant> = _restaurant

    fun setName(name: String) {
        _restaurant.value = _restaurant.value.copy(name = name)
    }

    fun setType(type: String) {
        _restaurant.value = _restaurant.value.copy(type = type)
    }

    fun setPoint(point: Double) {
        _restaurant.value = _restaurant.value.copy(point = point)
    }

    fun clear() {
        _restaurant.value = Restaurant("", "", "", 0.0)
    }

    fun save(navController: NavController, snackbarHostState: SnackbarHostState) {
        viewModelScope.launch {
            if (addRestaurantUseCase(restaurant.value)) {
                navController.popBackStack()

            } else {
                snackbarHostState.showSnackbar("Error al guardar el restaurante")
            }
        }
    }
}