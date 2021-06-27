package com.arun.moviedb.sdk.dispatcher.actions.navigation

import com.arun.moviedb.sdk.dispatcher.actions.Action
import com.arun.moviedb.sdk.dispatcher.actions.ActionPayload
import com.arun.moviedb.sdk.dispatcher.actions.ActionTypes

enum class NavigationType {
    FORWARD,
    BACK,
    REPLACE
}

data class NavigationPayload(val navigationType: NavigationType, val screenName: String? = null): ActionPayload

data class NavigationAction(override val payload: NavigationPayload): Action(ActionTypes.NAVIGATE, payload)
