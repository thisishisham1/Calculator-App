package com.example.calculatorapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
    val screenWidth = configuration.screenWidthDp.dp
    val rowModifier = Modifier
        .fillMaxWidth()
        .height(screenWidth / 4)
    Column(
        modifier
            .fillMaxSize()
            .padding(vertical = 8.dp, horizontal = 10.dp)
    ) {
        // Switch color mode
        Row(
            Modifier
                .fillMaxWidth()
                .height(screenHeight / 10), horizontalArrangement = Arrangement.Center
        ) {
            Switch(
                checked = isDark,
                onCheckedChange = themeUpdated,
                thumbContent = {
                    if (isDark) {
                        Icon(
                            painter = painterResource(id = R.drawable.moon),
                            contentDescription = "Dark mode",
                            modifier.requiredSize(20.dp)
                        )
                    } else
                        Icon(
                            painter = painterResource(id = R.drawable.sun),
                            contentDescription = "Light mode",
                            modifier.requiredSize(20.dp)
                        )
                }, colors = SwitchDefaults.colors(
                    uncheckedBorderColor = Color.Transparent,
                    uncheckedThumbColor = Color.White,
                    uncheckedTrackColor = buttonMediumLight,
                    uncheckedIconColor = buttonHighDark,
                    checkedIconColor = buttonHighDark,
                    checkedTrackColor = buttonLowDark,
                )
            )
        }
        //calculator
        Column(
            Modifier
                .fillMaxSize()
        ) {
            OperationsAndResult(screenHeight = screenHeight, mainViewModel = vm)
            DashBoard(
                isDark = isDark, mainViewModel = vm, modifier = rowModifier
            )
        }
    }
}

