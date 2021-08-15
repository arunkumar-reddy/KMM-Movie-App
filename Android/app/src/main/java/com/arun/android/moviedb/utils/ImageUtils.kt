package com.arun.android.moviedb.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.arun.moviedb.sdk.screen.ScreenNames

object ImageUtils {
    fun getImageUrl(path: String): String {
        return "https://image.tmdb.org/t/p/w400$path"
    }

    fun getIconForScreen(screenName: String): ImageVector? {
        return when(screenName) {
            ScreenNames.HOME -> Icons.Filled.Home
            ScreenNames.SEARCH -> Icons.Filled.Search
            ScreenNames.FAVORITES -> Icons.Filled.Favorite
            else -> null
        }
    }
}
