package com.example.myapp.domain.usecase

import com.example.myapp.data.repository.RestaurantRepository
import com.example.myapp.domain.model.Restaurant
import kotlinx.coroutines.flow.Flow

class GetRestautantsUseCase(private val restaurantRepository: RestaurantRepository) {
    operator fun invoke(): Flow<List<Restaurant>>{
        return restaurantRepository.list()
    }
}