package com.example.feature_splash.ui

sealed class SplashUiState {
    data object Init : SplashUiState()
    data object LoggedIn : SplashUiState()
    data object NotLoggedIn : SplashUiState()
    data class Error(val message: String) : SplashUiState()
}