package com.example.weatherproj

import com.example.weatherproj.ui.weather.WeatherType

data class Weather(
    val cityName: String,
    val time: String,
    val weatherType: WeatherType,
    val isDay: Boolean,
    val humidity: String,
    val wind: String,
    val temperature: String,
    val cloudCover: String,
)

object FakeWeatherData {
    val list = listOf(
        Weather(
            "Tenran",
            "Aug 29",
            WeatherType.SUNNY,
            true,
            "50%",
            "1.5m/s",
            "30",
            "10%"
        ),
        Weather(
            "Mashhad",
            "Aug 29",
            WeatherType.RAINY,
            true,
            "66%",
            "1.9m/s",
            "26",
            "88%"
        ),
        Weather(
            "Sari",
            "Aug 29",
            WeatherType.CLOUDY,
            true,
            "70%",
            "2.3m/s",
            "22",
            "78%"
        ),
        Weather(
            "Tokyo",
            "Aug 29",
            WeatherType.STORMY,
            false,
            "62%",
            "1.1m/s",
            "24",
            "70%"
        ),
        Weather(
            "Toronto",
            "Aug 29",
            WeatherType.SNOWY,
            false,
            "45%",
            "2.1m/s",
            "8",
            "66%"
        ),
        Weather(
            "Toronto",
            "Aug 29",
            WeatherType.SNOWY,
            false,
            "45%",
            "2.1m/s",
            "8",
            "66%"
        ),
        Weather(
            "Toronto",
            "Aug 29",
            WeatherType.SNOWY,
            false,
            "45%",
            "2.1m/s",
            "8",
            "66%"
        ),
        Weather(
            "Toronto",
            "Aug 29",
            WeatherType.SNOWY,
            false,
            "45%",
            "2.1m/s",
            "8",
            "66%"
        ),
        Weather(
            "Toronto",
            "Aug 29",
            WeatherType.SNOWY,
            false,
            "45%",
            "2.1m/s",
            "8",
            "66%"
        ),
        Weather(
            "Toronto",
            "Aug 29",
            WeatherType.SNOWY,
            false,
            "45%",
            "2.1m/s",
            "8",
            "66%"
        ),
        Weather(
            "Toronto",
            "Aug 29",
            WeatherType.SNOWY,
            false,
            "45%",
            "2.1m/s",
            "8",
            "66%"
        ),
        Weather(
            "Toronto",
            "Aug 29",
            WeatherType.SNOWY,
            false,
            "45%",
            "2.1m/s",
            "8",
            "66%"
        ),
        Weather(
            "Toronto",
            "Aug 29",
            WeatherType.SNOWY,
            false,
            "45%",
            "2.1m/s",
            "8",
            "66%"
        )
    )
}

