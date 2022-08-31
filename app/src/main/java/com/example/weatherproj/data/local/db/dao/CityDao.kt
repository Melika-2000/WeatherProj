package com.example.weatherproj.data.local.db.dao

import androidx.room.*
import com.example.weatherproj.data.local.db.entity.CityEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CityDao {
    @Query("SELECT * FROM city ORDER BY name")
    fun getAllCities() : Flow<List<CityEntity>>

    @Query("SELECT * FROM city WHERE city_id=:cityId")
    fun getCity(cityId: Int) : Flow<CityEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(city: CityEntity)

    @Update
    suspend fun updateCity(city: CityEntity)

    @Delete
    suspend fun delete(city: CityEntity)
}