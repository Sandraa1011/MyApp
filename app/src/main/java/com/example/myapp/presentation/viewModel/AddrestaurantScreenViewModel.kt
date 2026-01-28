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
    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name


    private val _type = MutableStateFlow("")
    val type: StateFlow<String> = _type


    private val _point = MutableStateFlow("")
    val point: MutableStateFlow<String> = _point


    fun setName(name: String) {
        _name.value = name
    }


    fun setType(type: String) {
        _type.value = type
    }


    fun setPoint(point: String) {
        _point.value = point
    }

    fun clear() {
        _name.value = ""
        _type.value = ""
        _point.value = ""
    }
}
