package com.arun.android.moviedb.components.discover

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arun.android.moviedb.utils.ColorUtils
import com.arun.moviedb.sdk.models.actionable.ActionableDiscoverResult

@Composable
fun DiscoverWidget(title: String, data: List<ActionableDiscoverResult>) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text( text = title, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = ColorUtils.getColorFromHex("#FFC107"))
        Row(modifier = Modifier.padding(top = 16.dp).height(80.dp).horizontalScroll(rememberScrollState())) {
            data.forEach { item ->
                Column(modifier = Modifier.width(80.dp)) {
                    val text = item.result.title ?: item.result.name ?: ""
                    Text(text = text, fontSize = 15.sp, color = ColorUtils.getColorFromHex("#000000"))
                }
            }
        }
    }
}
