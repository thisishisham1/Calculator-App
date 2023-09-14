package com.example.calculatorapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.calculatorapp.ui.theme.buttonHighDark
import com.example.calculatorapp.ui.theme.buttonLowDark
import com.example.calculatorapp.ui.theme.buttonLowLight
import com.example.calculatorapp.ui.theme.buttonMediumDark
import com.example.calculatorapp.ui.theme.buttonMediumLight
import com.example.calculatorapp.ui.theme.textDark
import com.example.calculatorapp.ui.theme.textLight

@Composable
fun HomeCalculator(modifier: Modifier, isDark: Boolean, themeUpdated: (bool: Boolean) -> Unit) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    val rowModifier = Modifier
        .fillMaxWidth()
        .height(screenWidth / 4)
    var answer by remember {
        mutableStateOf("")
    }
    Column(
        modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
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
                            contentDescription = "",
                            modifier.requiredSize(15.dp)
                        )
                    } else
                        Icon(
                            painter = painterResource(id = R.drawable.sun),
                            contentDescription = "",
                            modifier.requiredSize(15.dp)
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
        Column(
            Modifier
                .fillMaxSize()
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .height(screenHeight / 4)
            ) {
                Row(
                    Modifier
                        .fillMaxHeight(1 / 4f)
                        .fillMaxWidth()
                ) {
                    Text(text = "hisham")
                }
                Row(
                    Modifier
                        .fillMaxHeight(3 / 4f)
                        .fillMaxWidth()
                ) {
                    Text(text = answer, textAlign = TextAlign.Right)
                }
            }
            DashBoard(
                screenWidth = screenWidth,
                modifier = rowModifier,
                isDark = isDark
            )


        }
    }
}


@Composable
fun DashBoard(
    screenWidth: Dp,
    modifier: Modifier,
    isDark: Boolean
) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(screenWidth / 4),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        MediumButton(number = "C", isDark = isDark)
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.requiredSize(90.dp), colors = ButtonDefaults.buttonColors(
                containerColor = if (isDark) buttonMediumDark else buttonMediumLight
            )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon),
                contentDescription = "",
                tint = if (isDark) textDark else textLight,
                modifier = Modifier.requiredSize(32.dp)
            )
        }
        MediumButton(number = "%", isDark = isDark)
        HighButton(number = "÷", isDark = isDark)
    }
    Row(
        modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        LowButton("7", isDark = isDark)
        LowButton("8", isDark = isDark)
        LowButton("9", isDark = isDark)
        HighButton(number = "×", isDark = isDark)
    }
    Row(
        modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        LowButton("4", isDark = isDark)
        LowButton("5", isDark = isDark)
        LowButton("6", isDark = isDark)
        HighButton(number = "-", isDark = isDark)

    }
    Row(
        modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        LowButton("1", isDark = isDark)
        LowButton("2", isDark = isDark)
        LowButton("3", isDark = isDark)
        HighButton(number = "+", isDark = isDark)

    }
    Row(
        modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        LowButton(".", isDark = isDark)
        LowButton("0", isDark = isDark)
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.requiredSize(90.dp), colors = ButtonDefaults.buttonColors(
                containerColor = if (isDark) buttonLowDark else buttonLowLight
            )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.union),
                contentDescription = "",
                tint = if (isDark) textDark else textLight,
                modifier = Modifier.requiredSize(32.dp)
            )
        }
        HighButton(number = "=", isDark = isDark)
    }

}