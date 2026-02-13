package com.example.myfirstapp.proyecto.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapp.domain.model.Restaurant
import com.example.myapp.domain.usecase.DeleteRestaurantsUseCase
import com.example.myapp.domain.usecase.GetRestautantsUseCase

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class RestaurantScreenViewModel (
    private val getRestautantsUseCase: GetRestautantsUseCase,
    private val deleteRestaurantsUseCase: DeleteRestaurantsUseCase
) : ViewModel(){

    private var _restaurants= getRestautantsUseCase()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000),emptyList())

    val restaurants: StateFlow<List<Restaurant>> = _restaurants

    fun removeProduct(id:String){
        viewModelScope.launch {
            deleteRestaurantsUseCase
        }
    }



}