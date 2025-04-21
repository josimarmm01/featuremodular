package com.example.featuremodular

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.featuremodular.navigation.AppNavHost
import com.example.featuremodular.ui.theme.FeatureModularTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FeatureModularTheme {
                val navController = rememberNavController()
                AppNavHost(navController = navController)
            }
        }
    }
}