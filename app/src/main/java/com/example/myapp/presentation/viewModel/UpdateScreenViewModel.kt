package com.example.myapp.presentation.viewModel



import androidx.compose.material3.SnackbarHostState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.myapp.domain.model.Restaurant
import com.example.myapp.domain.usecase.GetRestautantsUseCase
import com.example.myapp.domain.usecase.UpdateRestaurantUseCase

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class UpdateScreenViewModel (
    val getRestautantsUseCase: GetRestautantsUseCase,
    val updateRestaurantUseCase: UpdateRestaurantUseCase
): ViewModel() {
    private val _restaurant = MutableStateFlow(
        Restaurant(0, "", "", 0.0)
    )
    val restaurant: StateFlow<Restaurant> = _restaurant



    fun setId(id:Long){

    }
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
    fun update(navController: NavController,snackbarHostState: SnackbarHostState){
        viewModelScope.launch {
            if(updateRestaurantUseCase(restaurant.value)){
                navController.popBackStack()
            }else{
                snackbarHostState.showSnackbar("No ha podido modificar el libro")
            }
        }
    }
}

