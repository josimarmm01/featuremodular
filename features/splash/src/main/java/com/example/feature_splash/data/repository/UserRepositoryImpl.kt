package com.example.feature_splash.data.repository

import com.example.feature_splash.data.source.AuthService
import com.example.feature_splash.domain.UserRepository
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl(
    private val authService: AuthService
) : UserRepository {
    override fun getUserLoggedInStatus(): Flow<Boolean> {
        return authService.getUserLoggedInStatus()
    }
}