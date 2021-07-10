package com.arun.moviedb.sdk.dispatcher.actions.navigation

import com.arun.moviedb.sdk.dispatcher.actions.Action
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
