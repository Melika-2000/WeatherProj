package com.example.weatherproj.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CloudsResponse(
    @SerialName("all") val cloudinessPercent: Int? = null
)
