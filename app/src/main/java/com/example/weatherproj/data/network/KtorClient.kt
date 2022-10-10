package com.example.weatherproj.data.network

import android.util.Log
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

val httpClient = HttpClient(OkHttp) {

    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        })
    }

    install(HttpTimeout) {
        socketTimeoutMillis = 30000
        requestTimeoutMillis = 30000
        connectTimeoutMillis = 30000
    }

    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                Log.d("TAG", "log: $message")
            }
        }
    }

    defaultRequest {
        url {
            protocol = URLProtocol.HTTPS
            host = HttpRoutes.API_URL
            parameters.append("appid", "483fb65a2968d5af1845d706a4424156")
            parameters.append("units", "metric")
        }
    }
}
