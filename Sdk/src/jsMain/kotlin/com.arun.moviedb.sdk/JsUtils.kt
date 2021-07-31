package com.arun.moviedb.sdk

import com.arun.moviedb.sdk.dispatcher.actions.Action
import com.arun.moviedb.sdk.dispatcher.actions.ActionTypes
import com.arun.moviedb.sdk.dispatcher.actions.navigation.NavigationAction
import com.arun.moviedb.sdk.dispatcher.actions.navigation.NavigationType

@JsExport
object JsUtils {
    fun getAction(payload: dynamic): Action? {
        val type = payload["type"] as String?
        return type?.let {
            when (ActionTypes.valueOf(type)) {
                ActionTypes.INCREMENT_COUNTER -> Action(ActionTypes.INCREMENT_COUNTER)
                ActionTypes.DECREMENT_COUNTER -> Action(ActionTypes.DECREMENT_COUNTER)
                ActionTypes.LOAD_HOME_SCREEN -> Action(ActionTypes.LOAD_HOME_SCREEN)
                ActionTypes.SEARCH_QUERY -> Action(ActionTypes.SEARCH_QUERY)
                ActionTypes.NAVIGATE -> buildNavigationAction(payload)
            }
        }
    }

    private fun buildNavigationAction(payload: dynamic): Action? {
        val navigationType = payload["navigationType"] as String?
        val screenName = payload["screenName"] as String?
        return navigationType?.let {
            NavigationAction(NavigationType.valueOf(it), screenName)
        }
    }
}
