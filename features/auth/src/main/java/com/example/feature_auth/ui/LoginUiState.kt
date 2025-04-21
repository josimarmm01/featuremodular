package com.example.feature_auth.ui

import com.example.feature_auth.domain.model.User

sealed class LoginUiState {
    data object Idle : LoginUiState()
    data object Loading : LoginUiState()
    data object Success : LoginUiState()
    data class Error(val message: String?) : LoginUiState()
}