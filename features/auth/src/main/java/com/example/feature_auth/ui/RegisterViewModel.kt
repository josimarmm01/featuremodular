package com.example.feature_auth.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_auth.domain.usecase.RegisterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<RegisterUiState>(RegisterUiState.Idle)
    val uiState: StateFlow<RegisterUiState> = _uiState.asStateFlow()


    fun register(name: String, email: String, password: String) {
        if (!isValidEmail(email)) {
            _uiState.value = RegisterUiState.Error("E-mail inválido")
            return
        }

        if (password.length < 6) {
            _uiState.value = RegisterUiState.Error("Senha deve ter no mínimo 6 caracteres")
            return
        }

        if (name.isBlank()) {
            _uiState.value = RegisterUiState.Error("Nome não pode estar vazio")
            return
        }

        viewModelScope.launch {
            _uiState.value = RegisterUiState.Loading

            registerUseCase(name, email, password)
                .catch { e ->
                    _uiState.value = RegisterUiState.Error(e.message ?: "Erro inesperado")
                }
                .collect { result ->
                    result
                        .onSuccess { user ->
                            _uiState.value = RegisterUiState.Success
                        }
                        .onFailure { error ->
                            _uiState.value = RegisterUiState.Error(error.message ?: "Falha no cadastro")
                        }
                }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return email.isNotBlank() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}