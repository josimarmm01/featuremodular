package com.example.core_network.di

import com.example.core_network.data.FirebaseAuthDataSource
import org.koin.dsl.module

val networkModule = module {
    single { FirebaseAuthDataSource() }
}