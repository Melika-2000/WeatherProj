package com.example.weatherproj.data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather")
data class WeatherEntity(
    @ColumnInfo(name = "weather_id") @PrimaryKey val weatherId: Int,
    @ColumnInfo(name = "humidity_percent") val humidityPercent: Int? = null,
    @ColumnInfo(name = "win_speed") val windSpeed: Int? = null,
    @ColumnInfo(name = "cloudiness_percent") val cloudinessPercent: Int? = null,
    val main: String,
    val description: String,
    val temperature: Float? = null,
    val time: Long,
    val sunrise: Long,
    val sunset: Long
)

