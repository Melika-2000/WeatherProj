package com.example.weatherproj.ui.cities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherproj.data.local.db.entity.CityEntity
import com.example.weatherproj.data.repository.CityRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CitiesViewModel(
    private val repository: CityRepository,
) : ViewModel() {

    // see if the ApiResponse return null when "cod" is not added

    fun deleteCity(cityName: String) {
        viewModelScope.launch {
            val city = cityEntityBuilder(cityName)
            city?.let { repository.deleteCity(it) }
        }
    }

    fun editCityName(cityName: String, newCityName: String) {
        viewModelScope.launch {
            val city = cityEntityBuilder(cityName)
            city?.let { repository.updateCity(it, newCityName) }
        }
    }


    fun insertCity(cityName: String) {
        viewModelScope.launch {
            val city = cityEntityBuilder(cityName)
            city?.let { repository.insertCity(it) }
        }
    }

    private suspend fun cityEntityBuilder(cityName:String): CityEntity?{
        val cityId = repository.getCityId(cityName)
        return cityId?.let { CityEntity(cityId = it, name= cityName) }
    }

}