package com.example.weatherproj.data.repository

import com.example.weatherproj.data.local.db.dao.CityDao
import com.example.weatherproj.data.local.db.entity.CityEntity

class CityRepository constructor(
    private val cityDao: CityDao
) {

    val cities = cityDao.getAllCities()

    fun getCity(cityId: Int) = cityDao.getCity(cityId)

    suspend fun deleteCity(city: CityEntity) = cityDao.deleteCity(city)

    suspend fun updateCity(city: CityEntity) = cityDao.updateCity(city)

}