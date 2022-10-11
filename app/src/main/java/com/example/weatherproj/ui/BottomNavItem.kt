
package com.example.weatherproj.ui
import com.example.weatherproj.R

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Cities : BottomNavItem(
        route = "cities",
        title = "Cities",
        icon = R.drawable.location_icon
    )

    object Weather : BottomNavItem(
        route = "weather",
        title = "Weather",
        icon = R.drawable.baseline_cloud_24
    )
}

