package com.example.calculatorapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.calculatorapp.ui.theme.buttonHighDark
import com.example.calculatorapp.ui.theme.buttonLowDark
import com.example.calculatorapp.ui.theme.buttonMediumLight

@Composable
fun HomeCalculator(isDark: Boolean, themeUpdated: (bool: Boolean) -> Unit) {
    val vm = remember {
        MainViewModel()
    }
    val modifier = Modifier
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    Column(
        modifier
            .fillMaxSize()
            .padding(vertical = 8.dp, horizontal = 10.dp)
    ) {
        ColorModeSwitch(isDark = isDark, onThemeUpdated = themeUpdated)
        CalculatorContent(screenHeight = screenHeight, isDark = isDark, viewModel = vm)
    }
}

@Composable
fun ColorModeSwitch(
    isDark: Boolean,
    onThemeUpdated: (Boolean) -> Unit
) {
    val iconRes = if (isDark) R.drawable.moon else R.drawable.sun

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Switch(
            checked = isDark,
            onCheckedChange = onThemeUpdated,
            thumbContent = {
                Icon(
                    painter = painterResource(id = iconRes),
                    contentDescription = if (isDark) "Dark mode" else "Light mode",
                    modifier = Modifier.requiredSize(20.dp)
                )
            },
            colors = SwitchDefaults.colors(
                uncheckedBorderColor = Color.Transparent,
                uncheckedThumbColor = Color.White,
                uncheckedTrackColor = buttonMediumLight,
                uncheckedIconColor = buttonHighDark,
                checkedIconColor = buttonHighDark,
                checkedTrackColor = buttonLowDark,
            )
        )
    }
}

@Composable
fun CalculatorContent(
    screenHeight: Dp,
    isDark: Boolean,
    viewModel: MainViewModel
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        OperationsAndResult(screenHeight = screenHeight, mainViewModel = viewModel)
        DashBoard(isDark = isDark, mainViewModel = viewModel)
    }
}
