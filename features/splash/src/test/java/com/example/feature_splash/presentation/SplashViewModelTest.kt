package com.example.feature_splash.presentation

import app.cash.turbine.test
import com.example.feature_splash.domain.usecase.UserLoggedInUseCase
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SplashViewModelTest {

    private lateinit var useCase: UserLoggedInUseCase
    private lateinit var viewModel: SplashViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        useCase = mockk()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `uiState should be LoggedIn when useCase returns true`() = runTest {
        // Given
        coEvery { useCase.invoke() } returns flowOf(true)

        // When
        viewModel = SplashViewModel(useCase)

        // Then
        viewModel.uiState.test {
            val result = awaitItem()
            assertEquals(SplashUiState.LoggedIn, result)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `uiState should be NotLoggedIn when useCase returns false`() = runTest {
        // Given
        coEvery { useCase.invoke() } returns flow {
            delay(10) // Simula tempo de resposta
            emit(false)
        }

        // When
        viewModel = SplashViewModel(useCase)

        // Then
        viewModel.uiState.test {
            assertEquals(SplashUiState.Init, awaitItem())
            assertEquals(SplashUiState.NotLoggedIn, awaitItem())
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `uiState should be Error when useCase throws exception`() = runTest {
        // Given
        val errorMessage = "Falha"
        coEvery { useCase.invoke() } returns flow { throw RuntimeException(errorMessage) }

        // When
        viewModel = SplashViewModel(useCase)

        // Then
        viewModel.uiState.test {
            val result = awaitItem()
            assertTrue(result is SplashUiState.Error)
            assertEquals(errorMessage, (result as SplashUiState.Error).message)
            cancelAndIgnoreRemainingEvents()
        }
    }
}
