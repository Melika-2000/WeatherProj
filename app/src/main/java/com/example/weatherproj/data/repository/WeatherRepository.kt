package com.example.weatherproj.data.repository

import com.example.weatherproj.data.local.db.dao.WeatherDao

class WeatherRepository constructor(
    private val weatherDao: WeatherDao
) {
    fun getWeather(cityId: Int) = weatherDao.getWeather(cityId)
}