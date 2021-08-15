package com.arun.android.moviedb.components.appbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arun.android.moviedb.utils.ColorUtils
import com.arun.moviedb.sdk.viewmodels.appbar.AppBarState

@Composable
fun AppBar(appBar: AppBarState) {
    Box(
        modifier = Modifier.background(ColorUtils.getColorFromHex(appBar.appBarColor)).fillMaxWidth().fillMaxHeight()
    ) {
        Text(
            text = appBar.title,
            color = ColorUtils.getColorFromHex(appBar.appBarTextColor),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp).align(Alignment.CenterStart)
        )
    }
}
