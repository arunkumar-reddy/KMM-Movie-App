package com.arun.moviedb.sdk.navigation

import kotlinx.browser.window

actual class NavigationManager: Navigator {
    private val navigator = CommonNavigator()

    actual override fun navigateTo(screenName: String) {
        navigator.navigateTo(screenName)
        getCurrentScreen()?.let {
            val historyEntry = window.history.state.asDynamic()
            if (screenName == historyEntry["screenName"]) {
                return
            }
            window.history.pushState(getHistoryEntry(it), screenName, screenName)
        }
    }

    actual override fun goBack() {
        navigator.goBack()
    }

    actual override fun replaceAndNavigateTo(screenName: String) {
        navigator.replaceAndNavigateTo(screenName)
        getCurrentScreen()?.let {
            window.history.replaceState(getHistoryEntry(it), screenName, screenName)
        }
    }

    actual override fun getCurrentScreen(): NavigationState? {
        return navigator.getCurrentScreen()
    }

    private fun getHistoryEntry(screen: NavigationState): dynamic {
        val historyEntry: dynamic = object {}
        historyEntry["screenName"] = screen.screenName
        historyEntry["screenType"] = screen.screenType.name
        return historyEntry
    }
}
