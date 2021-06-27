package com.arun.moviedb.sdk

import com.arun.moviedb.sdk.navigation.NavigationManager
import com.arun.moviedb.sdk.screen.ScreenTypes
import com.arun.moviedb.sdk.viewmodels.CounterViewModel
import com.arun.moviedb.sdk.viewmodels.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

data class AppState(var screenName: String, var screenType: ScreenTypes) {
    var screenViewModel: MutableStateFlow<ViewModel>? = when(screenType) {
        ScreenTypes.COUNTER -> MutableStateFlow(CounterViewModel(this, 0))
        else -> null
    }
    var navigationManager: NavigationManager? = null
}