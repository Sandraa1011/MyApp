package com.example.myapp.domain.usecase

import com.example.myapp.data.repository.RestaurantRepository
import com.example.myapp.domain.model.Restaurant

class AddRestaurantUseCase (val restaurantRepository: RestaurantRepository){
    suspend operator fun invoke(restaurant: Restaurant) : Boolean{
        return restaurantRepository.save(restaurant)
    }
}