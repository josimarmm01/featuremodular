package com.example.features_auth.domain.repository

import com.example.features_auth.domain.model.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun login(email: String, password: String): Flow<Result<User>>
    fun register(name: String, email: String, password: String): Flow<Result<User>>
}