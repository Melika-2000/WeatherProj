package com.example.weatherproj

enum class WeatherType(
    val description: String,
    val icon: Int
) {
    SUNNY("Clear sky", R.drawable.sun_icon),
    CLOUDY("Cloudy", R.drawable.cloud_icon),
    RAINY("Rainy", R.drawable.rain_icon),
    SNOWY("Snowy", R.drawable.snow_icon),
    STORMY("Stormy", R.drawable.storm_icon)
}
