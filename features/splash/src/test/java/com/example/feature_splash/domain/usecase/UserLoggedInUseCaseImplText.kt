package com.example.feature_splash.domain.usecase

import app.cash.turbine.test
import com.example.feature_splash.domain.repository.UserRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class UserLoggedInUseCaseImplText {

    private lateinit var repository: UserRepository
    private lateinit var useCase: UserLoggedInUseCaseImpl

    @Before
    fun setUp() {
        repository = mockk()
        useCase = UserLoggedInUseCaseImpl(repository)
    }

    @Test
    fun `invoke should emit value from repository`() = runTest {

        // Given
        val expected = true
        coEvery { repository.getUserLoggedInStatus() } returns flowOf(expected)

        // When & Then
        useCase().test {
            assert(awaitItem() == expected)
            awaitComplete()
        }
    }
}