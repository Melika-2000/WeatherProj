package com.example.weatherproj.data.network

enum class StatusCode(val value: Int) {
    OK(200),
    FORBIDDEN_ERROR(403),
    GATEWAY_TIMEOUT(503)
}