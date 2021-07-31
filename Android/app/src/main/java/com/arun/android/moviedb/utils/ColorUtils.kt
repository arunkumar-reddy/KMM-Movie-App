package com.arun.android.moviedb.utils

import androidx.compose.ui.graphics.Color

object ColorUtils {
    fun getColorFromHex(colorString: String): Color {
        return Color(android.graphics.Color.parseColor(colorString))
    }
}

object Colors {
    val appYellow = ColorUtils.getColorFromHex("#FFC107")
    val appBlack = ColorUtils.getColorFromHex("#171717")
}
