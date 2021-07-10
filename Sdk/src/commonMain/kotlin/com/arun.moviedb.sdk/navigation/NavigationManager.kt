package com.arun.moviedb.sdk.navigation

import com.arun.moviedb.sdk.navigation.router.Router

class NavigationManager: Navigator {
    private val navigationStack: ArrayDeque<NavigationState> = ArrayDeque()

    override fun navigateTo(screenName: String) {
        val screenType = Router.getScreenType(screenName)
        navigationStack.add(NavigationState(screenName, screenType))
    }

    override fun goBack() {
        if (!navigationStack.isEmpty()) {
            navigationStack.removeLast()
        }
    }

    override fun replaceAndNavigateTo(screenName: String) {
        val screenType = Router.getScreenType(screenName)
        if (!navigationStack.isEmpty()) {
            navigationStack.removeLast()
        }
        navigationStack.add(NavigationState(screenName, screenType))
    }

    override fun getCurrentScreen(): NavigationState? {
        if (!navigationStack.isEmpty()) {
            return navigationStack.last()
        }
        return null
    }
}
