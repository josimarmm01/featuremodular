package com.example.feature_auth.domain.usecase

import com.example.feature_auth.domain.model.User
import com.example.feature_auth.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow

class RegisterUseCaseImpl(private val repository: AuthRepository): RegisterUseCase {
    override fun invoke(name: String, email: String, password: String): Flow<Result<Unit>> {
       return repository.register(name, email, password)
    }
}