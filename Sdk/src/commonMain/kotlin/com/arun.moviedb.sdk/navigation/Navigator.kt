package com.arun.moviedb.sdk.navigation

import com.arun.moviedb.sdk.screen.ScreenTypes
import kotlin.js.JsName

data class NavigationState(
    @JsName("screenName") val screenName: String,
    @JsName("screenType") val screenType: ScreenTypes,
    @JsName("prevState") val prevState: NavigationState? = null
)

interface Navigator {
    fun navigateTo(screenName: String)
    fun goBack()
    fun replaceAndNavigateTo(screenName: String)
    fun getCurrentScreen(): NavigationState?
}
