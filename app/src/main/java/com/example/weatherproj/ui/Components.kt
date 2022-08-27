package com.example.weatherproj.ui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

@Composable
private fun ImageLoader(id: Int){
    Image(
        painter = painterResource(id = id),
        "picture",

        )
}