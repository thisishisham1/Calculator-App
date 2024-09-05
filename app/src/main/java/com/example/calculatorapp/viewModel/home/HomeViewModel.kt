package com.example.calculatorapp.viewModel.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import org.mariuszgromada.math.mxparser.Expression
import androidx.compose.runtime.State


class HomeViewModel : ViewModel() {
    private val _operation = mutableStateOf("")
    val operation: State<String> = _operation

    private val _answer = mutableStateOf(0.0)
    val answer: State<Double> = _answer

    fun updateOperation(value: String) {
        _operation.value = _operation.value.plus(value)
    }

    fun clearOperation() {
        _operation.value = ""
        _answer.value = 0.0
    }

    fun deleteLastCharacter() {
        if (_operation.value.isNotEmpty()) {
            _operation.value = _operation.value.dropLast(1)
        }
    }

    fun calculateAnswer() {
        try {
            _answer.value = Expression(_operation.value).calculate()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
