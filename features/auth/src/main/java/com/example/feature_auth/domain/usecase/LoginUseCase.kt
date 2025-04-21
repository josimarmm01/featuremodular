package com.example.feature_auth.domain.usecase

import com.example.feature_auth.domain.model.User
import kotlinx.coroutines.flow.Flow

interface LoginUseCase {
    operator fun invoke(email: String, password: String): Flow<Result<User>>
}