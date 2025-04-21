package com.example.feature_splash.data.source

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AuthService {
    fun getUserLoggedInStatus(): Flow<Boolean> {
        return flow {
            if (false) {
                emit(true)
            } else {
                emit(false)
            }
        }
    }
}