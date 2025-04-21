package com.example.feature_auth.domain.usecase

import kotlinx.coroutines.flow.Flow

interface RegisterUseCase {
    operator fun invoke(name: String, email: String, password: String): Flow<Result<Unit>>
}