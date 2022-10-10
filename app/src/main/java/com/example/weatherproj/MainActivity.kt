package com.example.weatherproj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.weatherproj.data.local.db.AppDatabase
import com.example.weatherproj.data.network.ApiCall
import com.example.weatherproj.data.network.httpClient
import com.example.weatherproj.ui.cities.CitiesScreen
import com.example.weatherproj.ui.theme.WeatherProjTheme
import com.example.weatherproj.ui.weather.WeatherScreen
import io.ktor.client.request.*
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherProjTheme {

//                val fakeData = FakeWeatherData.list
//                CitiesScreen(fakeData)
//                WeatherScreen(fakeData.get(4))

                runBlocking {
                    val apiCall = ApiCall(httpClient)
                    //  val aa = apiCall.fetchWeatherByCityId(524901)
                    val test = apiCall.fetchWeatherByCityName("London")
                    println("++++ " + test)
                }
            }
        }
    }
}
