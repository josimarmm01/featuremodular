package com.example.feature_auth.data.repository

import com.example.feature_auth.data.source.AuthService
import com.example.feature_auth.domain.model.User
import com.example.feature_auth.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AuthRepositoryImpl(private val authService: AuthService) : AuthRepository {
    override fun login(email: String, password: String): Flow<Result<User>> {
        return authService.login(email, password)
    }

    override fun register(name: String, email: String, password: String): Flow<Result<User>> = flow {
        val user = User("2", name, email)
        emit(Result.success(user))
    }
}