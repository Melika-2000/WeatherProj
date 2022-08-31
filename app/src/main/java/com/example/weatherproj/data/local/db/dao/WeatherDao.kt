package com.example.weatherproj.data.local.db.dao

import androidx.room.*
import com.example.weatherproj.data.local.db.entity.CityAndWeather
import com.example.weatherproj.data.local.db.entity.WeatherEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

    @Query("SELECT * FROM weather WHERE weather_id=:weatherId")
    fun getWeather(weatherId: Int): Flow<WeatherEntity>

    @Transaction
    @Query("SELECT * FROM city WHERE city_id IN (SELECT DISTINCT(weather_id) FROM weather)")
    fun getWeatherOfCities(): Flow<List<CityAndWeather>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(weather: WeatherEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(weathers: List<WeatherEntity>)

}