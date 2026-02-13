package com.example.myapp.data.di

import com.example.myapp.data.repository.RestaurantRepository
import com.example.myapp.domain.usecase.AddRestaurantUseCase
import com.example.myapp.domain.usecase.DeleteRestaurantsUseCase
import com.example.myapp.domain.usecase.GetRestautantsUseCase
import com.example.myapp.domain.usecase.ListRestaurantUseCase
import com.example.myapp.domain.usecase.UpdateRestaurantUseCase
import com.example.myapp.presentation.ui.screens.AddRestaurantScreen
import com.example.myapp.presentation.viewModel.UpdateScreenViewModel
import com.example.myfirstapp.proyecto.presentation.viewmodel.AddRestaurantScreenViewModel
import com.example.myfirstapp.proyecto.presentation.viewmodel.LoginScreenViewModel
import com.example.myfirstapp.proyecto.presentation.viewmodel.RestaurantScreenViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module{
    single { FirebaseFirestore.getInstance() }

    single { RestaurantRepository (get()) }

    factory { DeleteRestaurantsUseCase(get()) }
    factory { GetRestautantsUseCase(get ()) }
    factory { AddRestaurantUseCase(get()) }
    factory { ListRestaurantUseCase(get()) }
    factory { UpdateRestaurantUseCase(get()) }

    viewModel { RestaurantScreenViewModel(get(), get()) }
    viewModel { AddRestaurantScreenViewModel(get()) }
    viewModel { LoginScreenViewModel() }
    viewModel { UpdateScreenViewModel(get(),get()) }


}