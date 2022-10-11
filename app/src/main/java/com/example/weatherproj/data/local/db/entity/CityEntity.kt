package com.example.weatherproj.data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "city")
data class CityEntity(
    @ColumnInfo(name = "city_id") @PrimaryKey val cityId: Int,
    @ColumnInfo(name = "name") val name: String? = null,
)