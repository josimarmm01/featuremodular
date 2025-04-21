package com.example.feature_auth.data.source

import com.example.feature_auth.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AuthService {
    fun login(email: String, password: String): Flow<Result<User>> {
        return flow {
            if (email == "user@example.com" && password == "password") {
                emit(Result.success(User(id = "1", name = "User", email = email)))
            } else {
                emit(Result.failure(Exception("Invalid credentials")))
            }
        }
    }
}