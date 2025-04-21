package com.example.core_network.data

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

class FirebaseAuthDataSource {

    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    fun isUserLoggedIn(): Flow<Boolean> = flow {
        emit(firebaseAuth.currentUser != null)
    }

    fun login(email: String, password: String): Flow<Result<Unit>> = flow {
        try {
            firebaseAuth.signInWithEmailAndPassword(email, password).await()
            emit(Result.success(Unit))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    fun register(email: String, password: String): Flow<Result<Unit>> = flow {
        try {
            firebaseAuth.createUserWithEmailAndPassword(email, password).await()
           emit(Result.success(Unit))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    fun logout() {
        firebaseAuth.signOut()
    }
}