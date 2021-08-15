package com.arun.android.moviedb.components.discover

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.arun.android.moviedb.utils.Colors
import com.arun.android.moviedb.utils.ImageUtils
import com.arun.moviedb.sdk.models.actionable.ActionableDiscoverResult

@Composable
fun DiscoverWidget(title: String, data: List<ActionableDiscoverResult>) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text( text = title, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Colors.appYellow, modifier = Modifier.padding(8.dp))
        LazyRow(modifier = Modifier
            .padding(top = 16.dp)
            .height(240.dp)
        ) {
            items(data) { item ->
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
        Column(modifier = Modifier.width(160.dp).padding(8.dp)) {
            Image(
                painter = rememberImagePainter(
                    data = ImageUtils.getImageUrl(posterPath),
                    builder = {
                        crossfade(true)
                    }
                ),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth().fillMaxHeight(0.9f).align(Alignment.CenterHorizontally)
            )
            Text(
                text = titleText,
                fontSize = 16.sp,
                color = Colors.appWhite,
                overflow = TextOverflow.Visible,
                softWrap = true,
                modifier = Modifier.padding(top = 8.dp).align(Alignment.CenterHorizontally)
            )
        }
    }
}
