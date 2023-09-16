package com.example.calculatorapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
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
import org.mariuszgromada.math.mxparser.Expression
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun HomeCalculator(modifier: Modifier, isDark: Boolean, themeUpdated: (bool: Boolean) -> Unit) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    val rowModifier = Modifier
        .fillMaxWidth()
        .height(screenWidth / 4)
    val df = DecimalFormat("#.####")
    df.roundingMode = RoundingMode.DOWN
    var operation = remember {
        mutableStateOf("")
    }
    var answer = remember {
        mutableStateOf(0.0)
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
                    Text(
                        text = df.format(answer.value),
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
                        text = operation.value,
                        style = MaterialTheme.typography.headlineLarge.copy(textAlign = TextAlign.End),

                        )
                }
            }
            DashBoard(
                screenWidth = screenWidth,
                modifier = rowModifier,
                isDark = isDark, operation = operation, answer = answer
            )


        }
    }
}

@Composable
fun DashBoard(
    screenWidth: Dp,
    modifier: Modifier,
    isDark: Boolean,
    operation: MutableState<String>,
    answer: MutableState<Double>
) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(screenWidth / 4),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        MediumButton(
            number = "AC", isDark = isDark, onClick = {
                operation.value = ""
                answer.value = 0.0
            },
            Modifier
                .fillMaxWidth(2 / 4f)
                .requiredHeight(85.dp)
        )
        MediumButton(
            number = "%",
            isDark = isDark,
            onClick = { operation.value = operation.value.plus("%") },
        )
        HighButton(
            number = "÷",
            isDark = isDark,
            onClick = { operation.value = operation.value.plus("/") },
        )
    }
    Row(
        modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        LowButton("7", isDark = isDark, onClick = { operation.value = operation.value.plus("7") })
        LowButton("8", isDark = isDark, onClick = { operation.value = operation.value.plus("8") })
        LowButton("9", isDark = isDark, onClick = { operation.value = operation.value.plus("9") })
        HighButton(
            number = "×",
            isDark = isDark,
            onClick = { operation.value = operation.value.plus("*") })
    }
    Row(
        modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        LowButton("4", isDark = isDark, onClick = { operation.value = operation.value.plus("4") })
        LowButton("5", isDark = isDark, onClick = { operation.value = operation.value.plus("5") })
        LowButton("6", isDark = isDark, onClick = { operation.value = operation.value.plus("6") })
        HighButton(
            number = "-",
            isDark = isDark,
            onClick = { operation.value = operation.value.plus("-") })

    }
    Row(
        modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        LowButton("1", isDark = isDark, onClick = { operation.value = operation.value.plus("1") })
        LowButton("2", isDark = isDark, onClick = { operation.value = operation.value.plus("2") })
        LowButton("3", isDark = isDark, onClick = { operation.value = operation.value.plus("3") })
        HighButton(
            number = "+",
            isDark = isDark,
            onClick = { operation.value = operation.value.plus("+") })

    }
    Row(
        modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        LowButton(".", isDark = isDark, onClick = { operation.value = operation.value.plus(".") })
        LowButton("0", isDark = isDark, onClick = { operation.value = operation.value.plus("0") })
        Button(
            onClick = {
                if (operation.value.isEmpty()) null
                else operation.value = operation.value.substring(0, operation.value.length - 1)
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
        HighButton(number = "=", isDark = isDark, onClick = {
            try {
                answer.value = Expression(operation.value).calculate()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        })
    }

}