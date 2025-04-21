package com.example.feature_home.ui

import androidx.lifecycle.ViewModel
import com.example.feature_home.domain.usecase.LogoutUseCase

class HomeViewModel(
    private val logoutUseCase: LogoutUseCase
): ViewModel() {

    fun logout() {
        logoutUseCase.invoke()
    }

}