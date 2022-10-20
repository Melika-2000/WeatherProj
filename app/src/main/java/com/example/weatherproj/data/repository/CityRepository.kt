package com.example.weatherproj.data.repository

import com.example.weatherproj.data.local.db.dao.CityDao
import com.example.weatherproj.data.local.db.entity.CityEntity
import com.example.weatherproj.data.network.BaseApiCall
import com.example.weatherproj.data.network.StatusCode
import com.example.weatherproj.data.network.toCityEntity
import com.example.weatherproj.data.network.toWeatherEntity

class CityRepository(
    private val cityDao: CityDao,
    private val cityApiCall: BaseApiCall
) {

    val cities = cityDao.getAllCities()

    fun getCity(cityId: Int) = cityDao.getCity(cityId)

    suspend fun deleteCity(city: CityEntity) = cityDao.deleteCity(city)

    //How does it perform update? searches with cityId and change name?
    suspend fun updateCity(city: CityEntity, newCityName: String) {
        city.name = newCityName
        cityDao.updateCity(city)
    }

    suspend fun insertCity(city: CityEntity) {
        val result = city.name?.let { cityApiCall.fetchWeatherByCityName(it) }
        result?.let { cityDao.insertOrIgnoreCity(it.toCityEntity()) }
    }

    suspend fun getCityId(cityName: String): Int? {
        val result = cityApiCall.fetchWeatherByCityName(cityName)
     //   val result = cityName.let { cityApiCall.fetchWeatherByCityName(it) }
        return if (result.code == StatusCode.OK.value) result.cityId else null
    }

}