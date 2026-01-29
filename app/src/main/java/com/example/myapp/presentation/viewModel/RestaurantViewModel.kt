package com.example.myfirstapp.proyecto.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapp.domain.model.Restaurant

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RestaurantScreenViewModel : ViewModel() {
    private val _restaurant = MutableStateFlow<List<Restaurant>>(
        listOf(

            Restaurant(1, "Tagliatella", "Italiano", 4.3),


            Restaurant(2, "Goiko", "Hamburguesería", 4.7),


            Restaurant(3, "Jusco", "Japonés", 4.6),


            Restaurant(4, "Wok", "Buffet libre", 4.4),


            Restaurant(5, "Telepizza", "Pizzería", 3.7),


            )
    )
    val restaurant: StateFlow<List<Restaurant>> = _restaurant
}