package com.example.weatherproj.data.network


import android.content.Context
import com.example.weatherproj.data.network.model.ApiResponse
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ApiCallFake(private val path: String,private val context: Context) : BaseApiCall {

    override suspend fun fetchWeatherByCityName(cityName: String): ApiResponse {
        readFile(context)
        TODO("Not yet implemented")
    }

    override suspend fun fetchWeatherByCityId(cityId: Int): ApiResponse {
        TODO("Not yet implemented")
    }

    fun readFile(context: Context){
        //should read from file and convert it to ApiResponse
        //instead of using real Api from site

        val jsonString = Json.encodeToString(context.assets.open(path))
        println(jsonString)
        val obj = Json.decodeFromString<ApiResponse>(jsonString)
        println(obj)
    }

}