package com.example.featuremodular.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.features_auth.ui.HomeScreen
import com.example.features_auth.ui.LoginScreen
import com.example.features_auth.ui.RegisterScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "loginScreen") {

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