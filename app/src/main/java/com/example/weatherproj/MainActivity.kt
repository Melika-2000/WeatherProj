package com.example.weatherproj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.weatherproj.ui.cities.CitiesScreen
import com.example.weatherproj.ui.theme.WeatherProjTheme
import com.example.weatherproj.ui.weather.WeatherScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherProjTheme {
                val fakeData = FakeWeatherData.list
                CitiesScreen(fakeData)
              //  WeatherScreen(fakeData.get(4))
            }
        }
    }
}
