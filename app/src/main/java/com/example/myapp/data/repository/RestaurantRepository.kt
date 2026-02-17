package com.example.myapp.data.repository

import com.example.myapp.domain.model.Restaurant
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class RestaurantRepository(val firestore: FirebaseFirestore) {

    private val restaurantsCollection = firestore.collection("restaurants")

    suspend fun getById(id: String): Restaurant? {
        return try {
            val documentSnapshot = restaurantsCollection.document(id).get().await()
            documentSnapshot.toObject(Restaurant::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    fun list(): Flow<List<Restaurant>> {
        return queryForList(
            restaurantsCollection,
            Restaurant::class.java
        )
    }

    suspend fun save(restaurant: Restaurant): Boolean {
        return try {
            restaurantsCollection.add(restaurant).await()
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    suspend fun delete(id: String): Boolean {
        return try {
            // Agregamos .toString() aquí
            restaurantsCollection.document(id).delete().await()
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    private fun <T> queryForList(query: Query, clazz: Class<T>): Flow<List<T>> {
        return callbackFlow {
            val listener = query
                .addSnapshotListener { snapshots, error ->
                    if (error != null) {
                        close(error)
                        return@addSnapshotListener
                    }
                    val items = snapshots?.documents?.mapNotNull { doc ->
                        doc.toObject(clazz)

                    } ?: emptyList()
                    trySend(items)

                }
            awaitClose() { listener.remove() }
        }
    }

    private fun <T> queryForSingle(query: Query, clazz: Class<T>): Flow<T?> {
        return callbackFlow {
            val listener = query
                .addSnapshotListener { snapshots, error ->
                    if (error != null) {
                        close(error)
                        return@addSnapshotListener
                    }

                    val item = snapshots?.documents?.firstOrNull()?.toObject(clazz)

                    trySend(item)
                }
            awaitClose() { listener.remove() }
        }
    }

    suspend fun update(restaurant: Restaurant): Boolean {
        return try {
            restaurantsCollection.document(restaurant.id).update(
                "name",restaurant.name,
                "type",restaurant.type,
                "points",restaurant.point
            ).await()
            true
        }catch (e: Exception){
            e.printStackTrace()
            false
        }
    }
}
