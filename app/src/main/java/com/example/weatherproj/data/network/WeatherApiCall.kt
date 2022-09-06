package com.example.weatherproj.data.network

import com.example.weatherproj.data.network.model.WeatherResponse
import io.ktor.client.call.*
import io.ktor.client.request.*

class WeatherApiCall{

    private suspend fun deserializeWeather(): WeatherResponse {
        return KtorClient.httpClient.get(HttpRoutes.API_URL){
            url {
                parameters.append("id", "524901")
                parameters.append("appid", "483fb65a2968d5af1845d706a4424156")
                parameters.append("units", "metric")
            }
        }.body()
    }

}