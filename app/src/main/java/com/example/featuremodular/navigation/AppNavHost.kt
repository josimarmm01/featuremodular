package com.example.featuremodular.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.feature_splash.ui.SplashScreen
import com.example.feature_auth.ui.HomeScreen
import com.example.feature_auth.ui.LoginScreen
import com.example.feature_auth.ui.RegisterScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "splashScreen") {

        composable("splashScreen") {
            SplashScreen(navController = navController)
        }

        composable("loginScreen") {
            LoginScreen(navController = navController)
        }
        composable("registerScreen") {
            RegisterScreen(navController = navController)
        }
        composable("homeScreen") {
            HomeScreen(navController = navController)
        }
    }
}