package com.example.calculatorapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.calculatorapp.ui.theme.buttonLowDark
import com.example.calculatorapp.ui.theme.buttonLowLight
import com.example.calculatorapp.ui.theme.buttonMediumDark
import com.example.calculatorapp.ui.theme.textDark
import com.example.calculatorapp.ui.theme.textLight
import org.mariuszgromada.math.mxparser.Expression
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
    modifier: Modifier,
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
    Row(
        modifier,
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        NumberButton(
            number = "AC",
            isDark = isDark,
            modifier = Modifier
                .weight(1f)
                .height(90.dp),
            onClick = {
                mainViewModel.operation.value = ""
                mainViewModel.answer.value = 0.0
            },
            buttonType = ButtonType.MEDIUM

        )
        NumberButton(
            number = "÷",
            isDark = isDark,
            onClick = { mainViewModel.operation.value = mainViewModel.operation.value.plus("/") },
            buttonType = ButtonType.HIGH
        )
    }
    Row(
        modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        NumberButton(
            "7",
            isDark = isDark,
            onClick = { mainViewModel.operation.value = mainViewModel.operation.value.plus("7") },
            buttonType = ButtonType.LOW
        )
        NumberButton(
            "8",
            isDark = isDark,
            onClick = { mainViewModel.operation.value = mainViewModel.operation.value.plus("8") },
            buttonType = ButtonType.LOW
        )
        NumberButton(
            "9",
            isDark = isDark,
            onClick = { mainViewModel.operation.value = mainViewModel.operation.value.plus("9") },
            buttonType = ButtonType.LOW
        )
        NumberButton(
            number = "×",
            isDark = isDark,
            onClick = { mainViewModel.operation.value = mainViewModel.operation.value.plus("*") },
            buttonType = ButtonType.HIGH
        )
    }
    Row(
        modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        NumberButton(
            "4",
            isDark = isDark,
            onClick = { mainViewModel.operation.value = mainViewModel.operation.value.plus("4") },
            buttonType = ButtonType.LOW
        )
        NumberButton(
            "5",
            isDark = isDark,
            onClick = { mainViewModel.operation.value = mainViewModel.operation.value.plus("5") },
            buttonType = ButtonType.LOW
        )
        NumberButton(
            "6",
            isDark = isDark,
            onClick = { mainViewModel.operation.value = mainViewModel.operation.value.plus("6") },
            buttonType = ButtonType.LOW
        )
        NumberButton(
            number = "-",
            isDark = isDark,
            onClick = { mainViewModel.operation.value = mainViewModel.operation.value.plus("-") },
            buttonType = ButtonType.HIGH
        )

    }
    Row(
        modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        NumberButton(
            "1",
            isDark = isDark,
            onClick = { mainViewModel.operation.value = mainViewModel.operation.value.plus("1") },
            buttonType = ButtonType.LOW
        )
        NumberButton(
            "2",
            isDark = isDark,
            onClick = { mainViewModel.operation.value = mainViewModel.operation.value.plus("2") },
            buttonType = ButtonType.LOW
        )
        NumberButton(
            "3",
            isDark = isDark,
            onClick = { mainViewModel.operation.value = mainViewModel.operation.value.plus("3") },
            buttonType = ButtonType.LOW
        )
        NumberButton(
            number = "+",
            isDark = isDark,
            onClick = { mainViewModel.operation.value = mainViewModel.operation.value.plus("+") },
            buttonType = ButtonType.HIGH
        )

    }
    Row(
        modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        NumberButton(
            ".",
            isDark = isDark,
            onClick = { mainViewModel.operation.value = mainViewModel.operation.value.plus(".") },
            buttonType = ButtonType.LOW
        )
        NumberButton(
            "0",
            isDark = isDark,
            onClick = { mainViewModel.operation.value = mainViewModel.operation.value.plus("0") },
            buttonType = ButtonType.LOW
        )
        Button(
            onClick = {
                if (mainViewModel.operation.value.isEmpty()) null
                else mainViewModel.operation.value =
                    mainViewModel.operation.value.substring(
                        0,
                        mainViewModel.operation.value.length - 1
                    )
            },
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
        NumberButton(number = "=", isDark = isDark, onClick = {
            try {
                mainViewModel.answer.value = Expression(mainViewModel.operation.value).calculate()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }, buttonType = ButtonType.HIGH)
    }

}


private fun handleButtonClick(buttonText: String, mainViewModel: MainViewModel) {
    when (buttonText) {
        "AC" -> mainViewModel.clearOperationAndAnswer()
        "←" -> mainViewModel.removeLastCharFromOperation()
        "=" -> mainViewModel.calculateAnswer()
        else -> mainViewModel.appendToOperation(buttonText)
    }
}