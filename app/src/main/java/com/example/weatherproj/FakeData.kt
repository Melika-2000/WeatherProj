package com.example.weatherproj

data class FakeWeather(
    val cityName: String,
    val time: String,
    val weatherType: WeatherType,
    val isDay: Boolean,
    val humidity: String,
    val wind: String,
    val temperature: String,
    val moreDetail: String = ""
)

object FakeWeatherData {
    val list = listOf(
        FakeWeather(
            "Tenran",
            "Aug 29",
            WeatherType.SUNNY,
            true,
            "50%",
            "1.5m/s",
            "30.6c"
        ),
        FakeWeather(
            "Mashhad",
            "Aug 29",
            WeatherType.RAINY,
            true,
            "66%",
            "1.9m/s",
            "26c"
        ),
        FakeWeather(
            "Sari",
            "Aug 29",
            WeatherType.CLOUDY,
            true,
            "70%",
            "2.3m/s",
            "22.8c"
        ),
        FakeWeather(
            "Tokyo",
            "Aug 29",
            WeatherType.STORMY,
            false,
            "62%",
            "1.1m/s",
            "24.8c"
        ),
        FakeWeather(
            "Toronto",
            "Aug 29",
            WeatherType.SNOWY,
            false,
            "45%",
            "2.1m/s",
            "12c"
        )

    )
}

