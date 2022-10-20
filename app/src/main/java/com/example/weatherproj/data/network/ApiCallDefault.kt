package com.example.weatherproj.data.network

import com.example.weatherproj.data.network.model.ApiResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*


class ApiCallDefault(private val client : HttpClient) : BaseApiCall {
    override suspend fun fetchWeatherByCityName(cityName: String): ApiResponse {
        return client.get{
            url.parameters.append("q", cityName)
        }.body()
    }

    override suspend fun fetchWeatherByCityId(cityId: Int): ApiResponse {
        return client.get{
            url.parameters.append("id", cityId.toString())
        }.body()
    }

}