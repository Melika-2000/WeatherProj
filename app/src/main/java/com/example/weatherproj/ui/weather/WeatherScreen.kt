package com.example.weatherproj.ui.weather


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherproj.Weather
import com.example.weatherproj.R
import com.example.weatherproj.ui.*


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun WeatherScreen(weather: Weather) {
    WeatherBackground(isDay = weather.isDay) {
        Scaffold(
            backgroundColor = Color.Transparent,
            topBar = { TopBar(weather.isDay) },
            bottomBar = { BottomBar(weather.isDay) }
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Spacer(modifier = Modifier.size(15.dp))
                WeatherDetails(weather = weather)
                Spacer(modifier = Modifier.size(40.dp))
                WeatherTemperature(temperature = weather.temperature)
                CityName(name = weather.cityName)
                IconWithDescription(
                    iconId = weather.weatherType.icon,
                    description = weather.weatherType.description
                )

            }
        }
    }
}

@Composable
private fun WeatherTemperature(temperature: String) {
    Row() {
        CustomText(text = temperature, textSize = 60.sp)
        CustomText(text = "°C", fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun CityName(name: String) {
    CustomText(text = name, fontWeight = FontWeight.Bold)
}

@Composable
private fun WeatherDetails(weather: Weather) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        WeatherDetailsItem(iconId = R.drawable.cloud_icon, info = weather.cloudCover)
        Spacer(modifier = Modifier.size(30.dp))
        WeatherDetailsItem(iconId = R.drawable.wind, info = weather.wind)
        Spacer(modifier = Modifier.size(30.dp))
        WeatherDetailsItem(iconId = R.drawable.humidity, info = weather.humidity)
    }
}

@Composable
private fun WeatherDetailsItem(iconId: Int, info: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        CustomIcon(iconId = iconId)
        CustomText(text = info)
    }
}

@Composable
private fun WeatherBackground(isDay: Boolean, content: @Composable BoxScope.() -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        val id = if (isDay) R.drawable.day_background else R.drawable.night_background
        Image(
            painter = painterResource(id = id),
            "picture",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        content()
    }
}

