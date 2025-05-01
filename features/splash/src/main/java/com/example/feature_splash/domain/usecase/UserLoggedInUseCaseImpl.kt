package com.example.feature_splash.domain.usecase

import com.example.feature_splash.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class UserLoggedInUseCaseImpl(
    private val userRepository: UserRepository
): UserLoggedInUseCase {
    override operator fun invoke(): Flow<Boolean> {
        return userRepository.getUserLoggedInStatus()
    }
}