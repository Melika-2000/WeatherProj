package com.example.weatherproj.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    @SerialName("weather") val weather: List<WeatherResponse>? = null,
    @SerialName("main") val main: MainInfoResponse? = null,
    @SerialName("wind") val wind: WindResponse? = null,
    @SerialName("clouds") val clouds: CloudsResponse? = null,
    @SerialName("sys") val sys: SysResponse? = null,
    @SerialName("id") val cityId: Int,
    @SerialName("name") val name: String? = null,
    @SerialName("timezone") val time: Long? = null
)
