package com.arun.moviedb.sdk.navigation

import kotlinx.browser.window

actual class NavigationManager: Navigator {
    private val navigator = CommonNavigator()

    actual override fun navigateTo(screenName: String) {
        navigator.navigateTo(screenName)
        window.history.pushState(navigator.getCurrentScreen(), screenName, screenName)
    }

    actual override fun goBack() {
        navigator.goBack()
    }

    actual override fun replaceAndNavigateTo(screenName: String) {
        navigator.replaceAndNavigateTo(screenName)
        window.history.replaceState(navigator.getCurrentScreen(), screenName, screenName)
    }

    actual override fun getCurrentScreen(): NavigationState? {
        return navigator.getCurrentScreen()
    }
}
