package com.example.weatherproj.ui.cities

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherproj.Weather
import com.example.weatherproj.R
import com.example.weatherproj.ui.*
import com.example.weatherproj.ui.theme.LightNavyBlue
import com.example.weatherproj.ui.theme.NavyBlue


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CitiesScreen(data: List<Weather>) {

    Scaffold(
        backgroundColor = LightNavyBlue,
        topBar = { TopBar() },
        bottomBar = { BottomBar() }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(
                    start = 15.dp,
                    end = 15.dp,
                    bottom = it.calculateBottomPadding()
                )
        ) {
            item { SearchBar() }
            items(data) { city ->
                CustomCard(city)
            }
        }
    }

}

@Composable
private fun SearchBar() {

    var text by rememberSaveable {
        mutableStateOf("")
    }

    var citySearchResult by rememberSaveable {
        mutableStateOf(SearchResult.DEFAULT)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(top = 10.dp, bottom = 10.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(NavyBlue)
    ) {
        Row(
            modifier = Modifier.padding(top = 13.dp, start = 12.dp, end = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SearchField(
                text = text, onValueChange = {
                    text = it
                    citySearchResult = SearchResult.NOT_FOUND
                },
                modifier = Modifier.weight(5f)
            )
            Spacer(modifier = Modifier.size(10.dp))
            SearchButton(modifier = Modifier.weight(1f))
        }
        if (citySearchResult == SearchResult.NOT_FOUND) {
            Text(
                text = "City was not found!",
                fontSize = 12.sp,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 25.dp, bottom = 4.dp),
                color = Color.Red
            )
        }
    }
}

@Composable
private fun SearchField(
    text: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier
) {
    TextField(
        value = text,
        onValueChange = onValueChange,
        modifier = modifier
            .padding(vertical = 5.dp),
        placeholder = { Text(text = "City Name") },
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Gray,
            cursorColor = NavyBlue,
            disabledTextColor = Color.Transparent,
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}

@Composable
private fun SearchButton(modifier: Modifier, enabled: Boolean = true) {
    Button(
        onClick = {},
        enabled = enabled,
        modifier = modifier.height(55.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = LightNavyBlue,
            contentColor = Color.White
        )
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add icon",
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
private fun CustomCard(cityWeather: Weather) {
    val iconSize = 20.dp
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 7.dp)
            .height(60.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable { }, //TODO in next task
        backgroundColor = NavyBlue,
        contentColor = Color.White.copy(alpha = 0.8f),
        elevation = 10.dp
    ) {
        Row(
            modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomIcon(iconId = cityWeather.weatherType.icon, modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.size(10.dp))
            CustomText(text = cityWeather.cityName, modifier = Modifier.weight(6f))
            CustomIcon(
                iconId = R.drawable.edit_icon,
                size = iconSize,
                clickable = true,
                modifier = Modifier.weight(0.5f)
            )
            Spacer(modifier = Modifier.size(5.dp))
            CustomIcon(
                iconId = R.drawable.delete_icon,
                size = iconSize,
                clickable = true,
                modifier = Modifier.weight(0.5f)
            )
        }
    }
}