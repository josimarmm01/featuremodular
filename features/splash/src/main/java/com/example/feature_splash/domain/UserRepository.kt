package com.example.feature_splash.domain

import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUserLoggedInStatus(): Flow<Boolean>
}