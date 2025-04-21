package com.example.feature_home.di

import com.example.feature_home.data.UserRepositoryImpl
import com.example.feature_home.domain.repository.UserRepository
import com.example.feature_home.domain.usecase.LogoutUseCase
import com.example.feature_home.domain.usecase.LogoutUseCaseImpl
import com.example.feature_home.ui.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val homeModule = module {

    single<UserRepository> { UserRepositoryImpl(get()) }

    single<LogoutUseCase> { LogoutUseCaseImpl(get()) }

    viewModel { HomeViewModel(get()) }
}