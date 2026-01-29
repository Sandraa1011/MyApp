package com.example.myfirstapp.proyecto.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapp.domain.model.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AddRestaurantScreenViewModel : ViewModel() {


    private val _restaurant = MutableStateFlow(
        Restaurant(0, "", "", 0.0)
    )
    val restaurant: StateFlow<Restaurant> = _restaurant

    fun setName(name: String) {
        _restaurant.value = _restaurant.value.copy(name=name)
    }

    fun setType(type: String) {
        _restaurant.value = _restaurant.value.copy(type=type)
    }

    fun setPoint(point: Double) {
        _restaurant.value = _restaurant.value.copy(point=point)
    }
    fun clear() {
        _restaurant.value = Restaurant(0,"","",0.0)
    }
}