package com.arun.android.moviedb.components.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arun.android.moviedb.utils.ColorUtils
import com.arun.moviedb.sdk.models.actionable.ActionableDiscoverResult

@Composable
fun SearchResultsWidget(query: String, data: List<ActionableDiscoverResult>) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Showing results for: $query")
        data.forEach { item ->
            Column(modifier = Modifier.padding(top = 16.dp).fillMaxWidth()) {
                val text = item.result.title ?: item.result.name ?: ""
                val description = item.result.overview
                Text(text = text, fontSize = 20.sp, color = ColorUtils.getColorFromHex("#000000"))
                Text(text = description, fontSize = 14.sp, color = ColorUtils.getColorFromHex("#FFC107"))
            }
        }
    }
}
