package com.example.feature_splash.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_splash.domain.usecase.UserLoggedInUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class SplashViewModel(
    private val isUserLoggedInUseCase: UserLoggedInUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<SplashUiState>(SplashUiState.Init)
    val uiState: StateFlow<SplashUiState> = _uiState.asStateFlow()

    init {
        checkUserLoggedIn()
    }

    private fun checkUserLoggedIn() {
        viewModelScope.launch {
            isUserLoggedInUseCase()
                .catch {
                    _uiState.value = SplashUiState.Error(it.message ?: "Erro desconhecido")
                }
                .collect { isLoggedIn ->
                    _uiState.value = if (isLoggedIn) {
                        SplashUiState.LoggedIn
                    } else {
                        SplashUiState.NotLoggedIn
                    }
                }
        }
    }
}