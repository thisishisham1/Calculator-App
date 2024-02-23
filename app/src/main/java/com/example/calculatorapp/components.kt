package com.example.calculatorapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.calculatorapp.ui.theme.buttonHighDark
import com.example.calculatorapp.ui.theme.buttonHighLight
import com.example.calculatorapp.ui.theme.buttonLowDark
import com.example.calculatorapp.ui.theme.buttonLowLight
import com.example.calculatorapp.ui.theme.buttonMediumDark
import com.example.calculatorapp.ui.theme.buttonMediumLight
import com.example.calculatorapp.ui.theme.textDark
import com.example.calculatorapp.ui.theme.textLight
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun OperationsAndResult(
    screenHeight: Dp,
    mainViewModel: MainViewModel
) {
    val df = DecimalFormat("#.####")
    df.roundingMode = RoundingMode.DOWN

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
            Text(
                text = df.format(mainViewModel.answer.value),
                style = MaterialTheme.typography.headlineSmall,
                color = buttonMediumDark
            )
        }
        Row(
            Modifier
                .fillMaxHeight(3 / 4f)
                .fillMaxWidth()
        ) {
            Text(
                text = mainViewModel.operation.value,
                style = MaterialTheme.typography.headlineLarge.copy(
                    textAlign = TextAlign.End
                )
            )
        }
    }
}


@Composable
fun DashBoard(
    isDark: Boolean,
    mainViewModel: MainViewModel
) {
    val buttons = listOf(
        listOf("AC", "÷"),
        listOf("7", "8", "9", "×"),
        listOf("4", "5", "6", "-"),
        listOf("1", "2", "3", "+"),
        listOf(".", "0", "←", "=")
    )
    buttons.forEach { rows ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            rows.forEach { buttonText ->
                when (buttonText) {
                    "AC" -> NumberButton(
                        modifier = Modifier
                            .weight(1f)
                            .height(90.dp),
                        number = buttonText,
                        isDark = isDark,
                        onClick = { mainViewModel.handleButtonClick(buttonText) },
                        buttonType = ButtonType.MEDIUM
                    )

                    else -> NumberButton(
                        modifier = Modifier.requiredSize(90.dp),
                        number = buttonText,
                        isDark = isDark,
                        onClick = { mainViewModel.handleButtonClick(buttonText) },
                        buttonType = when (buttonText) {
                            "×", "-", "+", "=", "÷" -> ButtonType.HIGH
                            else -> ButtonType.LOW
                        }
                    )
                }

            }
        }
    }
}

@Composable
fun NumberButton(
    number: String,
    isDark: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    buttonType: ButtonType
) {
    val (buttonColor, shape) = when (buttonType) {
        ButtonType.LOW -> if (isDark) buttonLowDark to MaterialTheme.shapes.large else buttonLowLight to MaterialTheme.shapes.large
        ButtonType.MEDIUM -> if (isDark) buttonMediumDark to MaterialTheme.shapes.large else buttonMediumLight to MaterialTheme.shapes.large
        ButtonType.HIGH -> if (isDark) buttonHighDark to MaterialTheme.shapes.large else buttonHighLight to MaterialTheme.shapes.large
    }

    Button(
        onClick = onClick,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
            contentColor = if (isDark) textDark else textLight
        ),
        modifier = modifier
    ) {
        if (number == "←") {
            Icon(
                painter = painterResource(id = R.drawable.union),
                contentDescription = "",
                tint = if (isDark) textDark else textLight,
                modifier = Modifier.requiredSize(32.dp)
            )
        } else
            Text(
                text = number,
                style = MaterialTheme.typography.headlineSmall
            )
    }
}