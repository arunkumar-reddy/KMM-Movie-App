package com.arun.android.moviedb.screens.discover

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arun.android.moviedb.utils.ColorUtils
import com.arun.moviedb.sdk.models.discover.DiscoverResult

@Composable
fun DiscoverWidget(title: String, data: List<DiscoverResult>) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text( text = title, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = ColorUtils.getColorFromHex("#FFC107"))
        Row(modifier = Modifier.padding(top = 16.dp).horizontalScroll(rememberScrollState())) {
            data.forEach { discoverResult ->
                Column(modifier = Modifier.width(100.dp)) {
                    val text = discoverResult.title ?: discoverResult.name ?: ""
                    Text(text = text, fontSize = 15.sp, color = ColorUtils.getColorFromHex("#000000"))
                }
            }
        }
    }
}
