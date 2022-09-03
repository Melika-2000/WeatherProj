package com.example.weatherproj.ui

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.weatherproj.Weather
import com.example.weatherproj.ui.cities.CitiesScreen
import com.example.weatherproj.ui.theme.LightBlue
import com.example.weatherproj.ui.theme.NavyBlue
import com.example.weatherproj.ui.weather.WeatherScreen

@Composable
fun TopBar(isDay: Boolean = false) {
    val color = specifyColor(isDay = isDay)
    TopAppBar(backgroundColor = color,
        modifier = Modifier
            .height(50.dp)
            .graphicsLayer {
                clip = true
                shadowElevation = 5f
            }
    ) {
        CustomText(text = "Weather")
    }
}

@Composable
fun BottomBar(navController: NavController, isDay: Boolean = false) {
    val color = specifyColor(isDay = isDay)
    val screens = listOf(
        BottomNavItem.Cities,
        BottomNavItem.Weather,
    )
    BottomNavigation(
        backgroundColor = color,
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        screens.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(screen.icon), contentDescription = null,
                        modifier = Modifier.size(25.dp),
                        tint = Color.White.copy(alpha = 0.8f)
                    )
                },
                label = { CustomText(text = screen.title, textSize = 10.sp) },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {

                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun NavigationSetup(navController: NavHostController, data: List<Weather>) {
    NavHost(navController = navController, startDestination = BottomNavItem.Cities.route) {
        composable(BottomNavItem.Cities.route) {
            CitiesScreen(data)
        }
        composable(BottomNavItem.Weather.route) {
            WeatherScreen(data.get(3))
        }
    }
}

@Composable
fun CustomText(
    text: String,
    modifier: Modifier = Modifier,
    textSize: TextUnit = 20.sp,
    fontWeight: FontWeight? = null,
    color: Color = Color.White,
    alpha: Float = 0.8f
) {
    Text(
        text = text,
        color = color.copy(alpha = alpha),
        fontSize = textSize,
        fontWeight = fontWeight,
        modifier = modifier
    )
}

@Composable
fun CustomIcon(
    iconId: Int,
    size: Dp = 40.dp,
    clickable: Boolean = false,
    color: Color = Color.White,
    alpha: Float = 0.8f
) {
    val context = LocalContext.current
    Icon(
        painterResource(iconId),
        contentDescription = "icon",
        tint = color.copy(alpha = alpha),
        modifier = Modifier
            .size(size)
            .clickable(
                enabled = clickable,
                onClick = {
                    Toast
                        .makeText(context, "TODO", Toast.LENGTH_SHORT)
                        .show()
                }),
    )
}

@Composable
fun IconWithDescription(
    iconId: Int,
    description: String,
    iconSize: Dp = 160.dp,
    textSize: TextUnit = 20.sp,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomIcon(iconId = iconId, size = iconSize)
        CustomText(text = description, textSize = textSize)
    }
}

private fun specifyColor(isDay: Boolean): Color {
    return if (isDay) LightBlue else NavyBlue
}

