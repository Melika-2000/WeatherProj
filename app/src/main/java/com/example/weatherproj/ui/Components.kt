package com.example.weatherproj.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
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
import com.example.weatherproj.ui.weather.IconWithDescription

@Composable
fun TopBar(isDay: Boolean = false) {
    val color = ColorSetter(isDay = isDay)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = color)
            .graphicsLayer {
                clip = true
                shadowElevation = 3f
            }
            .padding(start = 10.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        CustomText(text = "Weather")
    }
}

@Composable
fun BottomBar(isDay: Boolean = false) {
    val color = ColorSetter(isDay = isDay)
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
    textSize: TextUnit = 20.sp,
    fontWeight: FontWeight? = null
) {
    Text(
        text = text,
        color = Color.White.copy(alpha = 0.8f),
        fontSize = textSize,
        fontWeight = fontWeight,
    )
}

@Composable
fun CustomIcon(
    iconId: Int,
    size: Dp = 40.dp,
    clickable: Boolean = false
) {
    Icon(
        painterResource(iconId),
        contentDescription = "icon",
        tint = Color.White.copy(alpha = 0.8f),
        modifier = Modifier
            .size(size)
            .clickable(enabled = clickable, onClick = {}),
        )
}

@Composable
fun ColorSetter(isDay: Boolean): Color {
    return if (isDay) LightBlue else NavyBlue
}
