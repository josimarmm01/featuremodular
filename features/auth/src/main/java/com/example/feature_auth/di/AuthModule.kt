package com.example.features_auth.di

import com.example.features_auth.data.repository.AuthRepositoryImpl
import com.example.features_auth.data.source.AuthService
import com.example.features_auth.domain.repository.AuthRepository
import com.example.features_auth.domain.usecase.LoginUseCase
import com.example.features_auth.domain.usecase.LoginUseCaseImpl
import com.example.features_auth.domain.usecase.RegisterUseCase
import com.example.features_auth.domain.usecase.RegisterUseCaseImpl
import com.example.features_auth.ui.LoginViewModel
import com.example.features_auth.ui.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val authModule = module {

    single { AuthService() }

    single<AuthRepository> { AuthRepositoryImpl(get()) }

    single<LoginUseCase> { LoginUseCaseImpl(get()) }
    single<RegisterUseCase> { RegisterUseCaseImpl(get()) }

    viewModel { LoginViewModel(get()) }
    viewModel { RegisterViewModel(get()) }
}