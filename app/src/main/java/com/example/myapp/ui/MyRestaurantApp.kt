package com.example.myapp.ui

import android.app.Application
import com.example.myapp.data.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyRestaurantApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyRestaurantApp)
            modules(appModule)
        }
    }
}