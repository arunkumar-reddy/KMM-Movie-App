package com.arun.moviedb.sdk.navigation

import com.arun.moviedb.sdk.screen.ScreenTypes

class NavigationState(val screenName: String, val screenType: ScreenTypes)

interface Navigator {
    fun navigateTo(screenName: String)
    fun goBack()
    fun replaceAndNavigateTo(screenName: String)
    fun getCurrentScreen(): NavigationState
}
