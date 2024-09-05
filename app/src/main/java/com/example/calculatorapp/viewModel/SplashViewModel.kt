package com.example.calculatorapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.calculatorapp.Destinations
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel(private val navController: NavController) : ViewModel() {
    init {
        navigateToMain()
    }

    private fun navigateToMain() {
        viewModelScope.launch {
            delay(3500)
            navController.navigate(Destinations.Home.route) {
                popUpTo(0)
            }
        }
    }
}

class SplashViewModelFactory(private val navController: NavController) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SplashViewModel(navController) as T
    }
}