package com.example.feature_auth.data.repository

import com.example.core_network.data.FirebaseAuthDataSource
import com.example.feature_auth.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow

class AuthRepositoryImpl(
    private val authService: FirebaseAuthDataSource
) : AuthRepository {
    override fun login(email: String, password: String): Flow<Result<Unit>>  {
        return authService.login(email, password)
    }

    override fun register(name: String, email: String, password: String): Flow<Result<Unit>> {
        return authService.register(email, password)
    }
}