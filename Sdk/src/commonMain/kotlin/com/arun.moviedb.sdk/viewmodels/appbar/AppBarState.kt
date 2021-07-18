package com.arun.moviedb.sdk.viewmodels.appbar

import kotlin.js.JsName

data class AppBarState(
    @JsName("title")
    val title: String = "MovieDB",
    @JsName("appBarColor")
    val appBarColor: String = "#171717",
    @JsName("appBarTextColor")
    val appBarTextColor: String = "#FFC107"
)
