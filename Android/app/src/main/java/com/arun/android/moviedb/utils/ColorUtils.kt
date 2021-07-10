package com.arun.android.moviedb.utils

import androidx.compose.ui.graphics.Color

object ColorUtils {
    fun getColorFromHex(colorString: String): Color {
        return Color(android.graphics.Color.parseColor(colorString))
    }
}
