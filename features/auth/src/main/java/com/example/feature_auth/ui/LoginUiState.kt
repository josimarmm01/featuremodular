package com.example.features_auth.ui

import com.example.features_auth.domain.model.User

sealed class LoginUiState {
    data object Idle : LoginUiState()
    data object Loading : LoginUiState()
    data class Success(val user: User?) : LoginUiState()
    data class Error(val message: String?) : LoginUiState()
}