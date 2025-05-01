package com.example.feature_splash.data.repository

import app.cash.turbine.test
import com.example.core_network.data.FirebaseAuthDataSource
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class UserRepositoryImplTest {

    private lateinit var authService: FirebaseAuthDataSource
    private lateinit var repository: UserRepositoryImpl

    @Before
    fun setUp() {
        authService = mockk()
        repository = UserRepositoryImpl(authService)
    }

    @Test
    fun `getUserLoggedInStatus should emit value from authService`() = runTest {

        // Given
        val expected = true
        coEvery { authService.isUserLoggedIn() } returns flowOf(expected)

        // When & Then
        repository.getUserLoggedInStatus().test {
            assert(awaitItem() == expected)
            awaitComplete()
        }
    }
}