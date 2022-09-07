package com.example.weatherproj.data.network

import com.example.weatherproj.data.network.model.ApiResponse
import io.ktor.client.call.*
import io.ktor.client.request.*

object ApiCall {
    suspend fun deserializeWeatherByCityName(cityName: String): ApiResponse {
        return KtorClient.httpClient.get(HttpRoutes.API_URL) {
            url {
                parameters.append("q", cityName)
                parameters.append("appid", "483fb65a2968d5af1845d706a4424156")
                parameters.append("units", "metric")
            }
        }.body()
    }

    suspend fun deserializeWeatherByCityId(cityId: Int): ApiResponse {
        return KtorClient.httpClient.get(HttpRoutes.API_URL) {
            url {
                parameters.append("id", cityId.toString())
                parameters.append("appid", "483fb65a2968d5af1845d706a4424156")
                parameters.append("units", "metric")
            }
        }.body()
    }

}