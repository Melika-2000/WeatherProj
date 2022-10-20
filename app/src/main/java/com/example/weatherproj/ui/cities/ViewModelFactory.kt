package com.example.weatherproj.ui.cities

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherproj.data.local.db.AppDatabase
import com.example.weatherproj.data.network.BaseApiCall
import com.example.weatherproj.data.repository.CityRepository

class ViewModelFactory(private val context: Context, private val apiCall: BaseApiCall) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val appDb = AppDatabase.getInstance(context = context)
        val cityRepository = CityRepository(appDb.cityDao, apiCall)
        return CitiesViewModel(cityRepository) as T
    }
}