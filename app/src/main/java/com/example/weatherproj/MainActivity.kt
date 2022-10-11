package com.example.weatherproj

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherproj.ui.BottomBar
import com.example.weatherproj.ui.NavigationSetup
import com.example.weatherproj.ui.TopBar
import com.example.weatherproj.ui.theme.LightNavyBlue
import com.example.weatherproj.ui.theme.WeatherProjTheme
import com.example.weatherproj.data.local.db.AppDatabase
import com.example.weatherproj.data.network.ApiCall
import com.example.weatherproj.data.network.httpClient
import com.example.weatherproj.ui.cities.CitiesScreen
import com.example.weatherproj.ui.theme.WeatherProjTheme
import com.example.weatherproj.ui.weather.WeatherScreen
import io.ktor.client.request.*
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherProjTheme {
                App()

//                runBlocking {
//                    val apiCall = ApiCall(httpClient)
//                    //  val aa = apiCall.fetchWeatherByCityId(524901)
//                   val test = apiCall.fetchWeatherByCityName("London")
//                    println("++++ " + test)
//                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun App() {
    val fakeData = FakeWeatherData.list
    val navController = rememberNavController()
    Scaffold(
        backgroundColor = LightNavyBlue,
        topBar = { TopBar() },
        bottomBar = { BottomBar(navController = navController) },
    ) {
        NavigationSetup(navController = navController, fakeData)
    }
}
