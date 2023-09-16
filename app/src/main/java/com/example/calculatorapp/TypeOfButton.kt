package com.example.calculatorapp

import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun LowButton(
    number: String,
    isDark: Boolean,
    onClick: () -> Unit
) {
    val sizeButton = Modifier.requiredSize(90.dp)
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(24.dp), colors = ButtonDefaults.buttonColors(
            containerColor = if (isDark) buttonLowDark else buttonLowLight,
            contentColor = if (isDark) {
                textDark
            } else {
                textLight
            }
        ),
        modifier = sizeButton
    ) {
        Text(
            text = number,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@Composable
fun MediumButton(
    number: String,
    isDark: Boolean, onClick: () -> Unit, sizeButton: Modifier = Modifier.requiredSize(90.dp)
) {

    Button(
        onClick = onClick,
        shape = RoundedCornerShape(24.dp), colors = ButtonDefaults.buttonColors(
            containerColor = if (isDark) buttonMediumDark else buttonMediumLight,
            contentColor = if (isDark) {
                textDark
            } else {
                textLight
            }
        ),
        modifier = sizeButton
    ) {
        Text(
            text = number,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@Composable
fun HighButton(
    number: String,
    isDark: Boolean, onClick: () -> Unit,
    sizeButton: Modifier = Modifier.requiredSize(90.dp)
) {

    Button(
        onClick = onClick,
        shape = RoundedCornerShape(24.dp), colors = ButtonDefaults.buttonColors(
            containerColor = if (isDark) buttonHighDark else buttonHighLight,
            contentColor = if (isDark) {
                textDark
            } else {
                textLight
            }
        ),
        modifier = sizeButton
    ) {
        Text(
            text = number,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}