package com.example.feature_splash.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.feature_splash.R
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = koinViewModel(),
    navController: NavController
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState) {

        delay(2000L)

        when (uiState) {
            is SplashUiState.LoggedIn -> {
                navController.navigate("homeScreen") {
                    popUpTo("splashScreen") { inclusive = true }
                }
            }

            is SplashUiState.NotLoggedIn -> {
                navController.navigate("loginScreen") {
                    popUpTo("splashScreen") { inclusive = true }
                }
            }

            is SplashUiState.Error -> {
                navController.navigate("loginScreen") {
                    popUpTo("splashScreen") { inclusive = true }
                }
            }

            else -> Unit
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_panorama_horizontal_select_24),
            contentDescription = "Logo do App",
            modifier = Modifier.size(100.dp)
        )
    }
}