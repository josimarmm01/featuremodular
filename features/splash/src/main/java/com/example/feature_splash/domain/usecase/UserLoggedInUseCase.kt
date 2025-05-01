package com.example.feature_splash.domain.usecase

import kotlinx.coroutines.flow.Flow

interface UserLoggedInUseCase {
    operator fun invoke(): Flow<Boolean>
}