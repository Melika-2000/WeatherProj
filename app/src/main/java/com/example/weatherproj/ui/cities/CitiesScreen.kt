package com.example.weatherproj.ui.cities

import androidx.compose.runtime.Composable
import com.example.weatherproj.FakeWeatherData
import com.example.weatherproj.ui.weather.WeatherScreen

@Composable
fun CitiesScreen() {
    val fakeData = FakeWeatherData.list
    WeatherScreen(fakeData.get(3))

}