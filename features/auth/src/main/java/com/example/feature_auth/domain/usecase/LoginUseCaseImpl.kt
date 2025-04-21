package com.example.features_auth.domain.usecase

import com.example.features_auth.domain.model.User
import com.example.features_auth.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow

class LoginUseCaseImpl(private val repository: AuthRepository) : LoginUseCase {
    override fun invoke(email: String, password: String): Flow<Result<User>> {
        return repository.login(email, password)
    }
}