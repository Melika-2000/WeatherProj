package com.example.weatherproj.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    @SerialName("weather") val weather: List<Weather>? = null,
    @SerialName("main") val main: MainInfo? = null,
    @SerialName("wind") val wind: Wind? = null,
    @SerialName("clouds") val clouds: Clouds? = null,
    @SerialName("sys") val sys: Sys? = null,
    @SerialName("id") val cityId: Int,
    @SerialName("name") val name: String? = null,
    @SerialName("timezone") val time: Long? = null
)
