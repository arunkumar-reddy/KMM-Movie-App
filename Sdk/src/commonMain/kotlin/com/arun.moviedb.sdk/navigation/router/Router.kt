package com.arun.moviedb.sdk.navigation.router

import com.arun.moviedb.sdk.AppState
import com.arun.moviedb.sdk.screen.ScreenNames
import com.arun.moviedb.sdk.screen.ScreenTypes
import com.arun.moviedb.sdk.viewmodels.counter.CounterViewModel
import com.arun.moviedb.sdk.viewmodels.ViewModel
import com.arun.moviedb.sdk.viewmodels.ViewModelCreator
import com.arun.moviedb.sdk.viewmodels.counter.CounterViewModelCreator
import kotlinx.coroutines.flow.MutableStateFlow

object Router {
    fun getScreenType(screenName: String): ScreenTypes {
        return when(screenName) {
            ScreenNames.DEFAULT -> ScreenTypes.COUNTER
            ScreenNames.HOME -> ScreenTypes.HOME
            ScreenNames.SEARCH -> ScreenTypes.BROWSE
            ScreenNames.ITEM -> ScreenTypes.ITEM
            ScreenNames.FAVORITES -> ScreenTypes.FAVORITES
            else -> ScreenTypes.HOME
        }
    }

    fun getViewModelForScreen(appState: AppState, screenTypes: ScreenTypes): MutableStateFlow<ViewModel> {
        val viewModelCreator: ViewModelCreator =  when(screenTypes) {
            ScreenTypes.COUNTER -> CounterViewModelCreator()
            else -> CounterViewModelCreator()
        }
        return viewModelCreator.createViewModel(appState)
    }
}
