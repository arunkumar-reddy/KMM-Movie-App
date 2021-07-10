package com.arun.moviedb.sdk

import com.arun.moviedb.sdk.navigation.NavigationState
import com.arun.moviedb.sdk.viewmodels.ViewModel
import com.arun.moviedb.sdk.viewmodels.appbar.AppBarState
import com.arun.moviedb.sdk.viewmodels.bottombar.BottomBarState

data class AppState(
    val appBarState: AppBarState? = null,
    val bottomBarState: BottomBarState? = null,
    val navigationState: NavigationState? = null,
    val screenViewModel: ViewModel? = null
)
