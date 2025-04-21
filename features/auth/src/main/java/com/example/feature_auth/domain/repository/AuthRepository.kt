package com.example.feature_auth.domain.repository

import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun login(email: String, password: String): Flow<Result<Unit>>
    fun register(name: String, email: String, password: String): Flow<Result<Unit>>
}