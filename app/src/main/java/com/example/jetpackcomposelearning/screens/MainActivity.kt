package com.example.jetpackcomposelearning.screens

import com.example.jetpackcomposelearning.screens.MainViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposelearning.ui.theme.JetpackComposeLearningTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().setKeepOnScreenCondition {
            viewModel.isLoading.value
        }

        setContent {
            JetpackComposeLearningTheme {
                // In your MainActivity.kt's setContent block
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "WelcomeScreen" // Start with the splash screen
                )
                {

                    // Define the welcome screen destination
                    composable(route = "WelcomeScreen")
                    {
                        WelcomeScreen(navController = navController) // Your main welcome screen composable }
                    }

                    composable("main_screen") {
                        MainScreen(navController = navController)
                    }
                }
            }
        }
    }
}