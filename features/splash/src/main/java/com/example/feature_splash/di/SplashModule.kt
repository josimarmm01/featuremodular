package com.example.feature_splash.di

import com.example.feature_splash.data.repository.UserRepositoryImpl
import com.example.feature_splash.data.source.AuthService
import com.example.feature_splash.domain.UserLoggedInUseCase
import com.example.feature_splash.domain.UserLoggedInUseCaseImpl
import com.example.feature_splash.domain.UserRepository
import com.example.feature_splash.ui.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val splashModule = module {

    single { AuthService() }

    single<UserRepository> { UserRepositoryImpl(get()) }

    single<UserLoggedInUseCase> { UserLoggedInUseCaseImpl(get()) }

    viewModel { SplashViewModel(get()) }
}