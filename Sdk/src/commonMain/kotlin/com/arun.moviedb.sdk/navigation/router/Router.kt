package com.arun.moviedb.sdk.navigation.router

import com.arun.moviedb.sdk.screen.ScreenNames
import com.arun.moviedb.sdk.screen.ScreenTypes
import com.arun.moviedb.sdk.viewmodels.ViewModel
import com.arun.moviedb.sdk.viewmodels.counter.CounterViewModelBuilder

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

    fun getViewModelForScreen(screenTypes: ScreenTypes): ViewModel {
        val viewModelBuilder =  when(screenTypes) {
            ScreenTypes.COUNTER -> CounterViewModelBuilder()
            else -> CounterViewModelBuilder()
        }
        return viewModelBuilder.build()
    }
}
