package com.example.feature_home.data.repository

import com.example.core_network.data.FirebaseAuthDataSource
import com.example.feature_home.domain.repository.UserRepository

class UserRepositoryImpl(
    private val authService: FirebaseAuthDataSource
): UserRepository {
    override fun logout() {
        authService.logout()
    }
}