package com.example.weatherproj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.weatherproj.data.network.ApiCall
import com.example.weatherproj.ui.theme.WeatherProjTheme
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherProjTheme {
//                val fakeData = FakeWeatherData.list
//                CitiesScreen(fakeData)
              //  WeatherScreen(fakeData.get(4))
                runBlocking {
                    val aa = ApiCall.deserializeWeatherByCityName("London")
                    println("%%%% " + aa)
                }

            }
        }
    }
}
