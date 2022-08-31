package com.example.weatherproj.data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "weather")
data class WeatherEntity(
    @ColumnInfo(name = "city_id") @PrimaryKey val cityId: Int,
    @ColumnInfo(name = "main") val main: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "temperature") val temperature: Float? = null,
    @ColumnInfo(name = "humidity_percent") val humidityPercent: Int? = null,
    @ColumnInfo(name = "win_speed") val windSpeed: Int? = null,
    @ColumnInfo(name = "cloudiness_percent") val cloudinessPercent: Int? = null,
  //  @ColumnInfo(name = "time") val time: Calendar
)

