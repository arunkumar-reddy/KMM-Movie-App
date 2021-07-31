package com.arun.moviedb.sdk.navigation

actual class NavigationManager: Navigator {
    private val navigator = CommonNavigator()

    actual override fun navigateTo(screenName: String) {
        navigator.navigateTo(screenName)
    }

    actual override fun goBack() {
        navigator.goBack()
    }

    actual override fun replaceAndNavigateTo(screenName: String) {
        navigator.replaceAndNavigateTo(screenName)
    }

    actual override fun getCurrentScreen(): NavigationState? {
        return navigator.getCurrentScreen()
    }
}
