package com.example.weatherproj.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weatherproj.data.local.db.dao.CityDao
import com.example.weatherproj.data.local.db.dao.WeatherDao
import com.example.weatherproj.data.local.db.entity.CityEntity
import com.example.weatherproj.data.local.db.entity.WeatherEntity


@Database(entities = [CityEntity::class, WeatherEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val cityDao : CityDao
    abstract val weatherDao : WeatherDao
}