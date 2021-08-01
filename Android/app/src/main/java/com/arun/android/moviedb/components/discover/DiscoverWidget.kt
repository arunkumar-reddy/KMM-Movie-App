package com.arun.android.moviedb.components.discover

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.arun.android.moviedb.utils.Colors
import com.arun.android.moviedb.utils.ImageUtils
import com.arun.moviedb.sdk.models.actionable.ActionableDiscoverResult

@Composable
fun DiscoverWidget(title: String, data: List<ActionableDiscoverResult>) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text( text = title, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Colors.appYellow)
        Row(modifier = Modifier
            .padding(top = 16.dp)
            .height(120.dp)
            .horizontalScroll(rememberScrollState())
        ) {
            data.forEach { item ->
                DiscoverWidgetItem(item)
            }
        }
    }
}

@Composable
fun DiscoverWidgetItem(item: ActionableDiscoverResult) {
    val titleText = item.result.title ?: item.result.name
    val posterPath = item.result.posterPath
    if (titleText != null && posterPath != null) {
        Column(modifier = Modifier.width(200.dp)) {
            //Text(text = titleText, fontSize = 15.sp, color = Colors.appWhite)
            Image(
                painter = rememberImagePainter(
                    data = ImageUtils.getImageUrl(posterPath),
                    builder = {
                        crossfade(true)
                    }
                ),
                contentDescription = null,
                modifier = Modifier.padding(8.dp).fillMaxWidth().fillMaxHeight().align(Alignment.CenterHorizontally)
            )
        }
    }
}
