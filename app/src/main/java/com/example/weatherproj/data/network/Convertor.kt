package com.example.weatherproj.data.network

import com.example.weatherproj.data.local.db.entity.CityEntity
import com.example.weatherproj.data.local.db.entity.WeatherEntity
import com.example.weatherproj.data.network.model.ApiResponse

fun ApiResponse.toWeatherEntity() =
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

fun ApiResponse.toCityEntity() =
    CityEntity(
        cityId = cityId,
        name = name
    )