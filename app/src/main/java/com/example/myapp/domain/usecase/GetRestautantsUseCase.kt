package com.example.myapp.domain.usecase

import com.example.myapp.data.repository.RestaurantRepository
import com.example.myapp.domain.model.Restaurant
import kotlinx.coroutines.flow.Flow

class GetRestautantsUseCase(private val restaurantRepository: RestaurantRepository) {
    suspend operator fun invoke(id:String): Restaurant?{
        return restaurantRepository.getById(id)
    }
}