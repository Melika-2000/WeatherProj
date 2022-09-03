package com.example.weatherproj.data.local.db.entity

import androidx.room.Embedded
import androidx.room.Relation

data class CityAndWeather(
    @Embedded val city: CityEntity,
    @Relation(
        parentColumn = "city_id",
        entityColumn = "city_id"
    )
    val weather: WeatherEntity
)
