package com.example.calculatorapp.view.home

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.calculatorapp.model.ButtonData


@Composable
fun LowButton(buttonData: ButtonData) {
    Button(
        onClick = buttonData.onClick,
        shape = RoundedCornerShape(24.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonData.containerColor,
            contentColor = buttonData.contentColor
        ),
        modifier = buttonData.sizeButton
    ) {
        Text(
            text = buttonData.number,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@Composable
fun MediumButton(buttonData: ButtonData) {
    Button(
        onClick = buttonData.onClick,
        shape = RoundedCornerShape(24.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonData.containerColor,
            contentColor = buttonData.contentColor
        ),
        modifier = buttonData.sizeButton
    ) {
        Text(
            text = buttonData.number,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@Composable
fun HighButton(buttonData: ButtonData) {
    Button(
        onClick = buttonData.onClick,
        shape = RoundedCornerShape(24.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonData.containerColor,
            contentColor = buttonData.contentColor
        ),
        modifier = buttonData.sizeButton
    ) {
        Text(
            text = buttonData.number,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}