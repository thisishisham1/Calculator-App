package com.example.calculatorapp.view.splash

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.calculatorapp.R
import com.example.calculatorapp.viewModel.SplashViewModel
import com.example.calculatorapp.viewModel.SplashViewModelFactory
import kotlinx.coroutines.delay

@Composable
fun SplashView(navController: NavController) {
    val composition = rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.icon)
    )
    val isVisible = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(500)
        isVisible.value = true
    }
    val viewModel: SplashViewModel = viewModel(
        factory = SplashViewModelFactory(navController)
    )


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(visible = isVisible.value, enter = fadeIn()) {
            LottieAnimation(composition = composition.value, modifier = Modifier.size(250.dp))
        }
    }
}
