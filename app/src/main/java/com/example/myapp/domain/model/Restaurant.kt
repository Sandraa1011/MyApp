package com.example.myapp.domain.model

import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.PropertyName
import kotlin.reflect.typeOf


data class Restaurant (
    @DocumentId val id: String="",
    @PropertyName("name") val name : String="",
    val type:String,
    val point: Double
) {
    constructor() :this(name = "",type= "", point=0.0)

}

