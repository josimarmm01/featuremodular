package com.example.feature_home.domain.usecase

import com.example.feature_home.domain.repository.UserRepository

class LogoutUseCaseImpl(private val repository: UserRepository) : LogoutUseCase {
    override fun invoke() {
        repository.logout()
    }
}