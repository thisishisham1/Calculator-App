package com.example.calculatorapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import org.mariuszgromada.math.mxparser.Expression

class MainViewModel : ViewModel() {
    val operation = mutableStateOf("")
    val answer = mutableStateOf(0.0)

    private fun clearOperationAndAnswer() {
        operation.value = ""
        answer.value = 0.0
    }

    private fun calculateAnswer() {
        try {
            answer.value = Expression(operation.value).calculate()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun appendToOperation(text: String) {
        operation.value += text
    }

    private fun removeLastCharFromOperation() {
        if (operation.value.isNotEmpty()) {
            operation.value = operation.value.dropLast(1)
        }
    }

    fun handleButtonClick(buttonText: String) {
        when (buttonText) {
            "AC" -> clearOperationAndAnswer()
            "←" -> removeLastCharFromOperation()
            "=" -> calculateAnswer()
            else -> appendToOperation(buttonText)
        }
    }
}
