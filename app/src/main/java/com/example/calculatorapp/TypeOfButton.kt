package com.example.calculatorapp

import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.calculatorapp.ui.theme.buttonHighDark
import com.example.calculatorapp.ui.theme.buttonHighLight
import com.example.calculatorapp.ui.theme.buttonLowDark
import com.example.calculatorapp.ui.theme.buttonLowLight
import com.example.calculatorapp.ui.theme.buttonMediumDark
import com.example.calculatorapp.ui.theme.buttonMediumLight
import com.example.calculatorapp.ui.theme.textDark
import com.example.calculatorapp.ui.theme.textLight

@Composable
fun NumberButton(
    number: String,
    isDark: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier.requiredSize(90.dp),
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
        Text(
            text = number,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

enum class ButtonType {
    LOW, MEDIUM, HIGH
}