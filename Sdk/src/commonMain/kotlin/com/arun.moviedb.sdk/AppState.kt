package com.arun.moviedb.sdk

import com.arun.moviedb.sdk.navigation.NavigationState
import com.arun.moviedb.sdk.viewmodels.ViewModel

data class AppState(
    val navigationState: NavigationState? = null,
    val screenViewModel: ViewModel? = null
)
