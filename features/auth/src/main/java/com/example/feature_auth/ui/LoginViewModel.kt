package com.example.feature_auth.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_auth.domain.usecase.LoginUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Idle)
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun login(email: String, password: String) {
        _uiState.value = LoginUiState.Loading

        viewModelScope.launch {
            loginUseCase.invoke(email, password).collect { result ->
                _uiState.value = when {
                    result.isSuccess -> LoginUiState.Success(user = result.getOrNull())
                    else -> LoginUiState.Error(message = result.exceptionOrNull()?.message)
                }
            }
        }
    }
}