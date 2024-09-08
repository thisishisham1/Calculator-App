package com.example.calculatorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calculatorapp.model.theme.CalculatorAppTheme
import com.example.calculatorapp.view.home.HomeCalculator
import com.example.calculatorapp.view.splash.SplashView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDark by remember { mutableStateOf(false) }
            MaterialTheme {
                CalculatorAppTheme(darkTheme = isDark) {
                    Surface {
                        MainNavigation(modifier = Modifier, isDark = isDark) {
                            isDark = !isDark
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MainNavigation(
    modifier: Modifier = Modifier,
    isDark: Boolean,
    themeUpdated: (Boolean) -> Unit
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Destinations.Splash.route) {
        composable(Destinations.Home.route) {
            HomeCalculator(
                modifier = modifier,
                isDark = isDark,
                themeUpdated = themeUpdated
            )
        }
        composable(Destinations.Splash.route) {
            SplashView(navController)
        }
    }
}