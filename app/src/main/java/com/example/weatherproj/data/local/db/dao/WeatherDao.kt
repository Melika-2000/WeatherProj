package com.example.weatherproj.data.local.db.dao

import androidx.room.*
import com.example.weatherproj.data.local.db.entity.CityAndWeather
import com.example.weatherproj.data.local.db.entity.WeatherEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

    @Query("SELECT * FROM weather WHERE city_id=:cityId")
    fun getWeather(cityId: Int): Flow<WeatherEntity>

    @Transaction
    @Query("SELECT * FROM city")
    fun getCityAndWeathers(): Flow<List<CityAndWeather>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(weather: WeatherEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeathers(weathers: List<WeatherEntity>)

}