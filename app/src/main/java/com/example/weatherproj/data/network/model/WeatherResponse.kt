package com.example.weatherproj.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    @SerialName("main") val main: String? = null,
    @SerialName("description") val description: String? = null,
    @SerialName("icon") val iconId: String? = null
)
