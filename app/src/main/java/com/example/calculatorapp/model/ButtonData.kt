package com.example.calculatorapp.model

import androidx.compose.foundation.layout.requiredSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

data class ButtonData(
    val number: String,
    val isDark: Boolean,
    val onClick: () -> Unit,
    val sizeButton: Modifier = Modifier.requiredSize(90.dp),
    val containerColor: Color,
    val contentColor: Color
)