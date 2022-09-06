package com.example.weatherproj.data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather")
data class WeatherEntity(
    @ColumnInfo(name = "city_id") @PrimaryKey val cityId: Int,
    @ColumnInfo(name = "humidity_percent") val humidityPercent: Int? = null,
    @ColumnInfo(name = "win_speed") val windSpeed: Float? = null,
    @ColumnInfo(name = "cloudiness_percent") val cloudinessPercent: Int? = null,
    @ColumnInfo(name = "main") val main: String? = null,
    @ColumnInfo(name = "description") val description: String? = null,
    @ColumnInfo(name = "temperature") val temperature: Float? = null,
    @ColumnInfo(name = "time") val time: Long? = null,
    @ColumnInfo(name = "sunrise") val sunrise: Long? = null,
    @ColumnInfo(name = "sunset") val sunset: Long? = null
)

