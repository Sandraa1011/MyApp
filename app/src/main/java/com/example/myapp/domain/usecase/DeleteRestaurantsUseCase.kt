package com.example.myapp.domain.usecase

import com.example.myapp.data.repository.RestaurantRepository

class DeleteRestaurantsUseCase(private val restaurantRepository: RestaurantRepository) {
    suspend fun invoke(id: Long): Boolean{
        return restaurantRepository.delete(id)
    }
}