package com.example.features_auth.domain.usecase

import com.example.features_auth.domain.model.User
import kotlinx.coroutines.flow.Flow

interface RegisterUseCase {
    operator fun invoke(name: String, email: String, password: String): Flow<Result<User>>
}