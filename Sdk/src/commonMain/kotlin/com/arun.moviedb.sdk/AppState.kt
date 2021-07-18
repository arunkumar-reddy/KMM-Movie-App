package com.arun.moviedb.sdk

import com.arun.moviedb.sdk.navigation.NavigationState
import com.arun.moviedb.sdk.viewmodels.ViewModel
import com.arun.moviedb.sdk.viewmodels.appbar.AppBarState
import com.arun.moviedb.sdk.viewmodels.bottombar.BottomBarState
import kotlin.js.JsName

data class AppState(
    @JsName("appBarState")
    val appBarState: AppBarState? = null,
    @JsName("bottomBarState")
    val bottomBarState: BottomBarState? = null,
    @JsName("navigationState")
    val navigationState: NavigationState? = null,
    @JsName("screenViewModel")
    val screenViewModel: ViewModel? = null
)
