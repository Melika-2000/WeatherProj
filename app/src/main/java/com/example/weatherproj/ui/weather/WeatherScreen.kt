package com.example.weatherproj.ui.weather


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherproj.FakeWeather
import com.example.weatherproj.R
import com.example.weatherproj.ui.*
import com.example.weatherproj.ui.theme.LightBlue
import com.example.weatherproj.ui.theme.NavyBlue

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun WeatherScreen(weather: FakeWeather) {
    Scaffold(
        backgroundColor = Color.Transparent,
        topBar = { TopBar(weather.isDay) },
        bottomBar = { BottomBar(weather.isDay) }
    ) {

        BackgroundSetter(isDay = weather.isDay)

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Spacer(modifier = Modifier.size(15.dp))
            TopRowInfo(weather = weather)
            Spacer(modifier = Modifier.size(40.dp))
            TemperatureDetail(temperature = weather.temperature)
            CityName(name = weather.cityName)
            IconWithDescription(
                iconId = weather.weatherType.icon,
                description = weather.weatherType.description
            )

        }
    }
}

@Composable
fun TemperatureDetail(temperature: String) {
    Row() {
        CustomText(text = temperature, textSize = 60.sp)
        CustomText(text = "°C", fontWeight = FontWeight.Bold)
    }
}

@Composable
fun CityName(name: String) {
    CustomText(text = name, fontWeight = FontWeight.Bold)
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

@Composable
private fun TopRowInfo(weather: FakeWeather) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        WeatherComponent(iconId = R.drawable.cloud_icon, info = weather.cloudCover)
        Spacer(modifier = Modifier.size(30.dp))
        WeatherComponent(iconId = R.drawable.wind, info = weather.wind)
        Spacer(modifier = Modifier.size(30.dp))
        WeatherComponent(iconId = R.drawable.humidity, info = weather.humidity)
    }
}

@Composable
private fun WeatherComponent(iconId: Int, info: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        CustomIcon(iconId = iconId)
        CustomText(text = info)
    }
}

@Composable
private fun BackgroundSetter(isDay: Boolean) {
    Box(modifier = Modifier.fillMaxSize()) {
        val id = if (isDay) R.drawable.day_background else R.drawable.night_background
        Image(
            painter = painterResource(id = id),
            "picture",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
    }
}

