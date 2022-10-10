package com.example.weatherproj.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WindResponse(
    @SerialName("speed") val windSpeed: Float? = null
)
