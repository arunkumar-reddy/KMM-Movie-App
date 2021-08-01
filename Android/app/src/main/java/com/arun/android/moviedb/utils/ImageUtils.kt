package com.arun.android.moviedb.utils

object ImageUtils {
    fun getImageUrl(path: String): String {
        return "https://image.tmdb.org/t/p/w400$path"
    }
}
