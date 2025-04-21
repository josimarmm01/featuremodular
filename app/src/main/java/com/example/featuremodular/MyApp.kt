package com.example.featuremodular

import android.app.Application
import com.example.core_network.di.networkModule
import com.example.feature_splash.di.splashModule
import com.example.feature_auth.di.authModule
import com.example.feature_home.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(networkModule, authModule, splashModule, homeModule)
        }
    }
}