package com.example.myapp.domain.model

import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.PropertyName


data class Restaurant (
    @DocumentId val id: Long=0,
    @PropertyName("restaurant_name") val name : String,
    val type:String,
    val point: Double
) {
}

