package com.example.calculatorapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import org.mariuszgromada.math.mxparser.Expression

class MainViewModel : ViewModel() {
    val operation = mutableStateOf("")
    val answer = mutableStateOf(0.0)

    fun clearOperationAndAnswer() {
        operation.value = ""
        answer.value = 0.0
    }

    fun calculateAnswer() {
        try {
            answer.value = Expression(operation.value).calculate()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun appendToOperation(text: String) {
        operation.value += text
    }

    fun removeLastCharFromOperation() {
        if (operation.value.isNotEmpty()) {
            operation.value = operation.value.dropLast(1)
        }
    }
}
