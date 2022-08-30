package com.example.weatherproj.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherproj.R
import com.example.weatherproj.ui.theme.LightBlue
import com.example.weatherproj.ui.theme.NavyBlue

@Composable
fun TopBar(isDay: Boolean = false) {
    val color = colorSetter(isDay = isDay)
    TopAppBar(backgroundColor = color,
        modifier = Modifier
            .height(50.dp)
            .graphicsLayer {
                clip = true
                shadowElevation = 5f
            }
    ) {
        CustomText(text = "Weather")
    }
}

@Composable
fun BottomBar(isDay: Boolean = false) { //TODO in navigation task
    val color = colorSetter(isDay = isDay)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = color)
            .height(50.dp)
            .graphicsLayer {
                clip = true
                shadowElevation = 3f
            }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .clickable { },
            contentAlignment = Alignment.Center
        ) {
            IconWithDescription(
                iconId = R.drawable.location_icon,
                "Cities",
                iconSize = 25.dp,
                textSize = 10.sp
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .clickable { },
            contentAlignment = Alignment.Center
        ) {
            IconWithDescription(
                iconId = R.drawable.baseline_cloud_24,
                "Weather",
                iconSize = 25.dp,
                textSize = 10.sp
            )
        }
    }
}

@Composable
fun CustomText(
    text: String,
    modifier: Modifier = Modifier,
    textSize: TextUnit = 20.sp,
    fontWeight: FontWeight? = null,
    color: Color = Color.White,
    alpha: Float = 0.8f
) {
    Text(
        text = text,
        color = color.copy(alpha = alpha),
        fontSize = textSize,
        fontWeight = fontWeight,
        modifier = modifier
    )
}

@Composable
fun CustomIcon(
    iconId: Int,
    modifier: Modifier = Modifier,
    size: Dp = 40.dp,
    clickable: Boolean = false,
    color: Color = Color.White,
    alpha: Float = 0.8f
) {
    Icon(
        painterResource(iconId),
        contentDescription = "icon",
        tint = color.copy(alpha = alpha),
        modifier = modifier
            .size(size)
            .clickable(enabled = clickable, onClick = {}),
    )
}

@Composable
fun IconWithDescription(
    iconId: Int,
    description: String,
    iconSize: Dp = 160.dp,
    textSize: TextUnit = 20.sp,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomIcon(iconId = iconId, size = iconSize)
        CustomText(text = description, textSize = textSize)
    }
}

private fun colorSetter(isDay: Boolean): Color {
    return if (isDay) LightBlue else NavyBlue
}

