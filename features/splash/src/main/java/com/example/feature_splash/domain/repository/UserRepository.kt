package com.example.feature_splash.domain.repository

import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUserLoggedInStatus(): Flow<Boolean>
}