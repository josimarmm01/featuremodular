package com.example.feature_auth.domain.usecase

import com.example.feature_auth.domain.model.User
import com.example.feature_auth.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow

class LoginUseCaseImpl(private val repository: AuthRepository) : LoginUseCase {
    override fun invoke(email: String, password: String): Flow<Result<User>> {
        return repository.login(email, password)
    }
}