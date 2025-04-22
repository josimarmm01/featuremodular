package com.example.feature_home.presentation

import com.example.feature_home.domain.usecase.LogoutUseCase
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class HomeViewModelTest {

    private lateinit var logoutUseCase: LogoutUseCase
    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() {
        logoutUseCase = mockk(relaxed = true)
        viewModel = HomeViewModel(logoutUseCase)
    }

    @Test
    fun `logout should call logoutUseCase`() {

        // When
        viewModel.logout()

        // Then
        verify(exactly = 1) { logoutUseCase.invoke() }
    }
}