package com.example.weatherproj

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.example.weatherproj.data.network.ApiCallFake
import com.example.weatherproj.ui.BottomBar
import com.example.weatherproj.ui.NavigationSetup
import com.example.weatherproj.ui.TopBar
import com.example.weatherproj.ui.theme.LightNavyBlue
import com.example.weatherproj.ui.theme.WeatherProjTheme


class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WeatherProjTheme {
                val filePath = "fakedatas.json"
                val fakeData = FakeWeatherData.list
//                val apiCAll = ApiCallDefault(httpClient)
                val apiCAll = ApiCallFake(filePath, LocalContext.current)
                val navController = rememberNavController()

                Scaffold(
                    backgroundColor = LightNavyBlue,
                    topBar = { TopBar() },
                    bottomBar = { BottomBar(navController = navController) },
                ) {
                    NavigationSetup(
                        navController = navController,
                        fakeData,
                        apiCAll
                    )

                }
            }
        }
    }
}
