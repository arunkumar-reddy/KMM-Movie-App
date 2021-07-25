package com.arun.moviedb.sdk.navigation.router

import com.arun.moviedb.sdk.screen.ScreenNames
import com.arun.moviedb.sdk.screen.ScreenTypes
import com.arun.moviedb.sdk.utils.ScreenUtils
import com.arun.moviedb.sdk.viewmodels.ViewModel
import com.arun.moviedb.sdk.viewmodels.counter.CounterViewModel
import com.arun.moviedb.sdk.viewmodels.home.HomeScreenViewModel
import com.arun.moviedb.sdk.viewmodels.search.SearchViewModel

object Router {
    fun getScreenType(screenName: String): ScreenTypes {
        return resolveAbsoluteRoutes(screenName) ?: resolveDynamicRoutes(screenName) ?: ScreenTypes.COUNTER
    }

    private fun resolveAbsoluteRoutes(screenName: String): ScreenTypes? {
        return when(screenName) {
            ScreenNames.DEFAULT -> ScreenTypes.COUNTER
            ScreenNames.HOME -> ScreenTypes.HOME
            ScreenNames.FAVORITES -> ScreenTypes.FAVORITES
            else -> null
        }
    }

    private fun resolveDynamicRoutes(screenName: String): ScreenTypes? {
        if (screenName.startsWith(ScreenNames.SEARCH)) {
            return ScreenTypes.BROWSE
        } else if (screenName.startsWith(ScreenNames.ITEM)) {
            return ScreenTypes.ITEM
        }
        return null
    }

    fun getViewModelForScreen(screenType: ScreenTypes, screenName: String): ViewModel {
        return when (screenType) {
            ScreenTypes.COUNTER -> CounterViewModel()
            ScreenTypes.HOME -> HomeScreenViewModel()
            ScreenTypes.BROWSE -> SearchViewModel(query = ScreenUtils.getSearchQueryFromScreenName(screenName))
            else -> CounterViewModel()
        }
    }
}
