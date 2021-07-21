package com.arun.moviedb.sdk.dispatcher.actions.navigation

import com.arun.moviedb.sdk.dispatcher.actions.Action
import com.arun.moviedb.sdk.dispatcher.actions.ActionBuilder
import com.arun.moviedb.sdk.dispatcher.actions.ActionTypes

enum class NavigationType {
    FORWARD,
    BACK,
    REPLACE
}

data class NavigationAction(
    val navigationType: NavigationType,
    val screenName: String? = null
): Action(ActionTypes.NAVIGATE)

class NavigationActionBuilder: ActionBuilder() {
    override fun buildAction(type: ActionTypes, jsObject: dynamic): NavigationAction? {
        val navigationType = jsObject["navigationType"] as String?
        val screenName = jsObject["screenName"] as String?
        navigationType?.let {
            return NavigationAction(NavigationType.valueOf(it), screenName)
        }
        return null
    }
}
