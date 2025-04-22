package com.example.feature_home.domain.usecase

import com.example.feature_home.domain.repository.UserRepository
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test


class LogoutUseCaseImplTest {

    private lateinit var repository: UserRepository
    private lateinit var logoutUseCase: LogoutUseCaseImpl

    @Before
    fun setUp() {
        repository = mockk(relaxed = true)
        logoutUseCase = LogoutUseCaseImpl(repository)
    }

    @Test
    fun `invoke should call repository logout`() {
        // When
        logoutUseCase.invoke()

        // Then
        verify(exactly = 1) { repository.logout() }
    }
}