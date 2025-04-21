package com.example.features_auth.domain.usecase

import com.example.features_auth.domain.model.User
import com.example.features_auth.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow

class RegisterUseCaseImpl(private val repository: AuthRepository): RegisterUseCase {
    override fun invoke(name: String, email: String, password: String): Flow<Result<User>> {
       return repository.register(name, email, password)
    }
}