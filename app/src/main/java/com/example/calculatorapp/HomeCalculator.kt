package com.example.calculatorapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.calculatorapp.ui.theme.buttonHighDark
import com.example.calculatorapp.ui.theme.buttonMediumDark
import com.example.calculatorapp.ui.theme.buttonMediumLight

@Composable
fun HomeCalculator(modifier: Modifier, isDark: Boolean, themeUpdated: (bool: Boolean) -> Unit) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    var countOperator = 0
    var countNum = 0
    val listOperator = listOf("×", "+", "-", "=")
    val listNumber = listOf("7", "8", "9", "4", "5", "6", "1", "2", "3", ".", "0", "D")
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
                    checkedTrackColor = buttonMediumDark,
                )
            )
        }
        Column(
            Modifier
                .fillMaxSize()
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(screenHeight / 4)
            ) {
                //todo:"Answer of calc"
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(screenWidth / 4),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier.requiredSize(90.dp), colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSystemInDarkTheme()) buttonMediumDark else buttonMediumLight
                    )
                ) {
                    Text(text = "C", style = MaterialTheme.typography.headlineSmall)
                }
                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier.requiredSize(90.dp), colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSystemInDarkTheme()) buttonMediumDark else buttonMediumLight
                    )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon),
                        contentDescription = "",
                        modifier.requiredSize(32.dp)
                    )
                }
                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier.requiredSize(90.dp), colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSystemInDarkTheme()) buttonMediumDark else buttonMediumLight
                    )
                ) {
                    Text(text = "%", style = MaterialTheme.typography.headlineSmall)
                }
                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier.requiredSize(90.dp), colors = ButtonDefaults.buttonColors(
                        containerColor = buttonHighDark
                    )
                ) {
                    Text(text = "÷", style = MaterialTheme.typography.headlineSmall)
                }

            }
            repeat(4) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(screenWidth / 4),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    repeat(3) {
                        Column(verticalArrangement = Arrangement.SpaceBetween) {
                            Button(
                                onClick = { /*TODO*/ },
                                shape = RoundedCornerShape(24.dp),
                                modifier = Modifier.requiredSize(90.dp)
                            ) {
                                Text(
                                    text = listNumber[countNum],
                                    style = MaterialTheme.typography.headlineSmall
                                )
                            }
                            countNum += 1
                        }
                    }
                    Button(
                        onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(24.dp),
                        modifier = Modifier.requiredSize(90.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = buttonHighDark
                        )
                    ) {
                        Text(
                            text = listOperator[countOperator],
                            style = MaterialTheme.typography.headlineSmall
                        )
                    }
                }
                countOperator += 1
            }


        }
    }
}
