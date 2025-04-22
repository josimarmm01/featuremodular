package com.example.feature_home.data.repository


import com.example.core_network.data.FirebaseAuthDataSource
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class UserRepositoryImplTest {

    private lateinit var authService: FirebaseAuthDataSource
    private lateinit var userRepository: UserRepositoryImpl

    @Before
    fun setUp() {
        authService = mockk()
        userRepository = UserRepositoryImpl(authService)
    }

    @Test
    fun `logout should call authService logout`() {

        every { authService.logout() } returns Unit

        // When
        userRepository.logout()

        // Then
        verify(exactly = 1) { authService.logout() }
    }
}