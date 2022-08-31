package com.example.weatherproj.data.local.db.entity

import androidx.room.Embedded
import androidx.room.Relation

data class CityAndWeather(
    val city: CityEntity,
    @Relation(
        parentColumn = "city_id",
        entityColumn = "weather_id"
    )
    @Embedded val weather: WeatherEntity
)
