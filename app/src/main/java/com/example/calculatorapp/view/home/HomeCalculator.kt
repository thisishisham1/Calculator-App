package com.example.calculatorapp.view.home

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculatorapp.R
import com.example.calculatorapp.model.ButtonData
import com.example.calculatorapp.model.theme.buttonHighDark
import com.example.calculatorapp.model.theme.buttonHighLight
import com.example.calculatorapp.model.theme.buttonLowDark
import com.example.calculatorapp.model.theme.buttonLowLight
import com.example.calculatorapp.model.theme.buttonMediumDark
import com.example.calculatorapp.model.theme.buttonMediumLight
import com.example.calculatorapp.model.theme.textDark
import com.example.calculatorapp.model.theme.textLight
import com.example.calculatorapp.viewModel.home.HomeViewModel
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun HomeCalculator(modifier: Modifier, isDark: Boolean, themeUpdated: (bool: Boolean) -> Unit) {
    val viewModel: HomeViewModel = viewModel()
    val operation = viewModel.operation.value
    val answer = viewModel.answer.value

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    val rowModifier = Modifier
        .fillMaxWidth()
        .height(screenWidth / 4)
    val df = DecimalFormat("#.####")
    df.roundingMode = RoundingMode.DOWN
    val operationColor = if (isDark) textDark else textLight
    val answerColor = buttonHighLight
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
                            modifier.requiredSize(20.dp)
                        )
                    } else
                        Icon(
                            painter = painterResource(id = R.drawable.sun),
                            contentDescription = "",
                            modifier.requiredSize(20.dp)
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
                .fillMaxWidth()
                .weight(1f)
                .padding(bottom = 16.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .height(screenHeight / 5)
            ) {
                HorizontalScrollableText(
                    text = operation,
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontSize = if (operation.length > 20) 24.sp else 30.sp
                    ),
                    color = operationColor,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                        .horizontalScroll(rememberScrollState())
                )
                Spacer(modifier = Modifier.weight(1f))
                HorizontalScrollableText(
                    text = df.format(answer),
                    style = MaterialTheme.typography.headlineMedium,
                    color = answerColor,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp)
                        .horizontalScroll(rememberScrollState())
                )
            }
            DashBoard(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f),
                isDark = isDark,
                viewModel = viewModel
            )
        }
    }
}

@Composable
fun DashBoard(
    modifier: Modifier,
    isDark: Boolean,
    viewModel: HomeViewModel
) {
    val buttonColors = if (isDark) {
        Triple(buttonLowDark, buttonMediumDark, buttonHighDark)
    } else {
        Triple(buttonLowLight, buttonMediumLight, buttonHighLight)
    }
    Row(
        modifier,
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        MediumButton(
            ButtonData(
                number = "AC",
                isDark = isDark,
                onClick = { viewModel.clearOperation() },
                sizeButton = Modifier
                    .fillMaxWidth(2 / 4f)
                    .requiredHeight(85.dp),
                containerColor = buttonColors.second,
                contentColor = if (isDark) textDark else textLight
            )
        )
        MediumButton(
            ButtonData(
                number = "%",
                isDark = isDark,
                onClick = { viewModel.updateOperation("%") },
                containerColor = buttonColors.second,
                contentColor = if (isDark) textDark else textLight
            )
        )
        HighButton(
            ButtonData(
                number = "÷",
                isDark = isDark,
                onClick = { viewModel.updateOperation("/") },
                containerColor = buttonColors.third,
                contentColor = if (isDark) textDark else textLight
            )
        )
    }
    Row(
        modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        LowButton(
            ButtonData(
                number = "7",
                isDark = isDark,
                onClick = { viewModel.updateOperation("7") },
                containerColor = buttonColors.first,
                contentColor = if (isDark) textDark else textLight
            )
        )
        LowButton(
            ButtonData(
                number = "8",
                isDark = isDark,
                onClick = { viewModel.updateOperation("8") },
                containerColor = buttonColors.first,
                contentColor = if (isDark) textDark else textLight
            )
        )
        LowButton(
            ButtonData(
                number = "9",
                isDark = isDark,
                onClick = { viewModel.updateOperation("9") },
                containerColor = buttonColors.first,
                contentColor = if (isDark) textDark else textLight
            )
        )
        HighButton(
            ButtonData(
                number = "×",
                isDark = isDark,
                onClick = { viewModel.updateOperation("*") },
                containerColor = buttonColors.third,
                contentColor = if (isDark) textDark else textLight
            )
        )
    }
    Row(
        modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        LowButton(
            ButtonData(
                number = "4",
                isDark = isDark,
                onClick = { viewModel.updateOperation("4") },
                containerColor = buttonColors.first,
                contentColor = if (isDark) textDark else textLight
            )
        )
        LowButton(
            ButtonData(
                number = "5",
                isDark = isDark,
                onClick = { viewModel.updateOperation("5") },
                containerColor = buttonColors.first,
                contentColor = if (isDark) textDark else textLight
            )
        )
        LowButton(
            ButtonData(
                number = "6",
                isDark = isDark,
                onClick = { viewModel.updateOperation("6") },
                containerColor = buttonColors.first,
                contentColor = if (isDark) textDark else textLight
            )
        )
        HighButton(
            ButtonData(
                number = "-",
                isDark = isDark,
                onClick = { viewModel.updateOperation("-") },
                containerColor = buttonColors.third,
                contentColor = if (isDark) textDark else textLight
            )
        )
    }
    Row(
        modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        LowButton(
            ButtonData(
                number = "1",
                isDark = isDark,
                onClick = { viewModel.updateOperation("1") },
                containerColor = buttonColors.first,
                contentColor = if (isDark) textDark else textLight
            )
        )
        LowButton(
            ButtonData(
                number = "2",
                isDark = isDark,
                onClick = { viewModel.updateOperation("2") },
                containerColor = buttonColors.first,
                contentColor = if (isDark) textDark else textLight
            )
        )
        LowButton(
            ButtonData(
                number = "3",
                isDark = isDark,
                onClick = { viewModel.updateOperation("3") },
                containerColor = buttonColors.first,
                contentColor = if (isDark) textDark else textLight
            )
        )
        HighButton(
            ButtonData(
                number = "+",
                isDark = isDark,
                onClick = { viewModel.updateOperation("+") },
                containerColor = buttonColors.third,
                contentColor = if (isDark) textDark else textLight
            )
        )
    }
    Row(
        modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        LowButton(
            ButtonData(
                number = ".",
                isDark = isDark,
                onClick = { viewModel.updateOperation(".") },
                containerColor = buttonColors.first,
                contentColor = if (isDark) textDark else textLight
            )
        )
        LowButton(
            ButtonData(
                number = "0",
                isDark = isDark,
                onClick = { viewModel.updateOperation("0") },
                containerColor = buttonColors.first,
                contentColor = if (isDark) textDark else textLight
            )
        )
        Button(
            onClick = {
                viewModel.deleteLastCharacter()
            },
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.requiredSize(90.dp),
            colors = ButtonDefaults.buttonColors(
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
        HighButton(
            ButtonData(
                number = "=",
                isDark = isDark,
                onClick = { viewModel.calculateAnswer() },
                containerColor = buttonColors.third,
                contentColor = if (isDark) textDark else textLight
            )
        )
    }
}

@Composable
fun HorizontalScrollableText(
    text: String,
    style: TextStyle,
    color: Color,
    modifier: Modifier = Modifier
) {
    Row(modifier) {
        Text(
            text = text,
            style = style,
            color = color,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}