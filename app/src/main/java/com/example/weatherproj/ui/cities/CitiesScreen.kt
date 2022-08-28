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
import com.example.weatherproj.FakeWeather
import com.example.weatherproj.FakeWeatherData
import com.example.weatherproj.R
import com.example.weatherproj.ui.*
import com.example.weatherproj.ui.theme.LightNavyBlue
import com.example.weatherproj.ui.theme.NavyBlue


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CitiesScreen() {
    val fakeData = FakeWeatherData.list

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
            items(fakeData) { city ->
                CustomCard(city)
            }
        }
    }

}

@Composable
fun SearchBar() {

    var text by rememberSaveable {
        mutableStateOf("")
    }

    var cityFound by rememberSaveable {
        mutableStateOf(SearchResult.DEFAULT)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .padding(top = 10.dp, bottom = 10.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(NavyBlue)
    ) {
        Row(
            modifier = Modifier.padding(13.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SearchField(
                text = text, onValueChange = {
                    text = it
                    cityFound = SearchResult.DEFAULT
                },
                modifier = Modifier.weight(5f)
            )
            Spacer(modifier = Modifier.size(10.dp))
            SearchButton(modifier = Modifier.weight(1f))
        }
        if (cityFound == SearchResult.NOTFOUND) {
            Text(
                text = "City was not found!",
                fontSize = 12.sp,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 25.dp, bottom = 4.dp),
                color = Color.Red
            )
        }
    }
}

@Composable
fun SearchField(
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
fun SearchButton(modifier: Modifier, enabled: Boolean = true) {
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
fun CustomCard(city: FakeWeather) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 7.dp)
            .height(60.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable { },
        backgroundColor = NavyBlue,
        contentColor = Color.White.copy(alpha = 0.8f),
        elevation = 10.dp
    ) {
        Row(
            modifier = Modifier.padding(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomIcon(iconId = city.weatherType.icon)
            Spacer(modifier = Modifier.size(10.dp))
            CustomText(text = city.cityName)
            EditingOptions()
        }
    }
}

@Composable
private fun EditingOptions() {
    val iconSize = 20.dp
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 5.dp),
        horizontalArrangement = Arrangement.End
    ) {
        CustomIcon(iconId = R.drawable.edit_icon, size = iconSize, clickable = true)
        Spacer(modifier = Modifier.size(5.dp))
        CustomIcon(iconId = R.drawable.delete_icon, size = iconSize, clickable = true)
    }
}