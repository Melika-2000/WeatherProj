package com.example.weatherproj.data.network

import com.example.weatherproj.data.network.model.ApiResponse

interface BaseApiCall {

    suspend fun fetchWeatherByCityName(cityName: String): ApiResponse

    suspend fun fetchWeatherByCityId(cityId: Int): ApiResponse

}