package com.example.weatherproj.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.weatherproj.data.local.db.dao.CityDao
import com.example.weatherproj.data.local.db.dao.WeatherDao
import com.example.weatherproj.data.local.db.entity.CityEntity
import com.example.weatherproj.data.local.db.entity.WeatherEntity


@Database(entities = [CityEntity::class, WeatherEntity::class], version = DbConfig.DATABASE_VERSION)
abstract class AppDatabase : RoomDatabase() {
    abstract val cityDao: CityDao
    abstract val weatherDao: WeatherDao

    companion object {

        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        fun getInstance(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            DbConfig.DATABASE_FILE_NAME
        )
            .build()
    }

}