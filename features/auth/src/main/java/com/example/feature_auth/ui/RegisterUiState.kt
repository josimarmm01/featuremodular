package com.example.features_auth.ui

import com.example.features_auth.domain.model.User

sealed class RegisterUiState {
    data object Idle : RegisterUiState()
    data object Loading : RegisterUiState()
    data class Success(val user: User?) : RegisterUiState()
    data class Error(val message: String?) : RegisterUiState()
}