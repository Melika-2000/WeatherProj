package com.example.weatherproj.data.network.model

import com.example.weatherproj.data.local.db.entity.WeatherEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    @SerialName("weather") val weather: List<Weather>? = null,
    @SerialName("main") val main: MainInfo? = null,
    @SerialName("wind") val wind: Wind? = null,
    @SerialName("clouds") val clouds: Clouds? = null,
    @SerialName("sys") val sys: Sys? = null,
    @SerialName("id") val cityId: Int,
    @SerialName("name") val name: String? = null,
    @SerialName("timezone") val time: Long? = null
)

fun WeatherResponse.toWeatherEntity() =
    WeatherEntity(
        cityId = cityId,
        humidityPercent = main?.humidityPercent,
        windSpeed = wind?.windSpeed,
        cloudinessPercent = clouds?.cloudinessPercent,
        description = weather?.first()?.description,
        main = weather?.first()?.main,
        temperature = main?.temperature,
        time = time,
        sunrise = sys?.sunrise,
        sunset = sys?.sunset
    )