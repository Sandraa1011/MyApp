package com.example.myapp.domain.usecase

import com.example.myapp.data.repository.RestaurantRepository

class DeleteRestaurantsUseCase(private val restaurantRepository: RestaurantRepository) {
    suspend operator fun invoke(id: String): Boolean{
        return restaurantRepository.delete(id)
    }
}