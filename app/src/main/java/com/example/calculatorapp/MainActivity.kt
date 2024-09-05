package com.example.calculatorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.calculatorapp.ui.theme.CalculatorAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDark by remember {
                mutableStateOf(false)
            }
            MaterialTheme() {
                CalculatorAppTheme(darkTheme = isDark) {
                    Surface {
                        HomeCalculator(
                            isDark = isDark,
                            themeUpdated = { isDark = !isDark })
                    }

                }

            }


        }
    }
}
