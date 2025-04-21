package com.example.feature_auth.ui

import com.example.feature_auth.domain.model.User

sealed class RegisterUiState {
    data object Idle : RegisterUiState()
    data object Loading : RegisterUiState()
    data class Success(val user: User?) : RegisterUiState()
    data class Error(val message: String?) : RegisterUiState()
}