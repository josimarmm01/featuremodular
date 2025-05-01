package com.example.feature_splash.data.repository

import com.example.core_network.data.FirebaseAuthDataSource
import com.example.feature_splash.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl(
    private val authService: FirebaseAuthDataSource
) : UserRepository {
    override fun getUserLoggedInStatus(): Flow<Boolean> {
        return authService.isUserLoggedIn()
    }
}