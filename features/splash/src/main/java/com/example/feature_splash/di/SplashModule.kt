package com.example.feature_splash.di

import com.example.feature_splash.data.repository.UserRepositoryImpl
import com.example.feature_splash.domain.usecase.UserLoggedInUseCase
import com.example.feature_splash.domain.usecase.UserLoggedInUseCaseImpl
import com.example.feature_splash.domain.repository.UserRepository
import com.example.feature_splash.presentation.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val splashModule = module {

    single<UserRepository> { UserRepositoryImpl(get()) }

    single<UserLoggedInUseCase> { UserLoggedInUseCaseImpl(get()) }

    viewModel { SplashViewModel(get()) }
}