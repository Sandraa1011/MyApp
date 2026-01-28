package com.example.myfirstapp.proyecto.presentation.viewmodel


import androidx.lifecycle.ViewModel
import com.example.myapp.domain.model.Restaurant

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class RestaurantScreenViewModel : ViewModel() {
    private val _restaurantCard = MutableStateFlow<List<RestaurantCard>>(
        listOf(
            RestaurantCard(
                Restaurant(1,"Tagliatella","Italiano",4.3),true
            ),
            RestaurantCard(
                Restaurant(2,"Goiko","Hamburguesería",4.7),true
            ),
            RestaurantCard(
                Restaurant(3,"Jusco","Japonés",4.6),true
            ),
            RestaurantCard(
                Restaurant(4,"Wok","Buffet libre",4.4),true
            ),
            RestaurantCard(
                Restaurant(5,"Telepizza","Pizzería",3.7),true
            ),


            )
    )
    val restaurantCards: StateFlow<List<RestaurantCard>> = _restaurantCard
    fun selected(id : Int){
        _restaurantCard.value=_restaurantCard.value.map {
                restaurantCard->
            if(restaurantCard.restaurant.id==id){
                restaurantCard.copy(
                    expanded = !restaurantCard.expanded
                )
            }else{
                restaurantCard
            }


        }
    }
}




data class RestaurantCard(
    val restaurant: Restaurant,
    val expanded: Boolean
)

