package com.example.weatherproj.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MainInfo(
    @SerialName("temp") val temperature: Float? = null,
    @SerialName("pressure") val pressure: Int? = null,
    @SerialName("humidity") val humidityPercent: Int? = null,

)
