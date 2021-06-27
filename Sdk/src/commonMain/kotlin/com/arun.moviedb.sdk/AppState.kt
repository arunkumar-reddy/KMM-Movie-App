package com.arun.moviedb.sdk

import com.arun.moviedb.sdk.navigation.NavigationState
import com.arun.moviedb.sdk.viewmodels.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

data class AppState(
    val navigationState: NavigationState? = null,
    val currentScreenViewModel: MutableStateFlow<ViewModel>? = null
)

