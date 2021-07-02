package com.arun.moviedb.sdk.dispatcher

import com.arun.moviedb.sdk.dispatcher.actions.ActionTypes
import com.arun.moviedb.sdk.handlers.ActionHandler
import com.arun.moviedb.sdk.handlers.counter.CounterActionHandler
import com.arun.moviedb.sdk.handlers.navigation.NavigationHandler
import com.arun.moviedb.sdk.navigation.NavigationManager

object ActionMapper {
    val navigationManager = NavigationManager()

    fun getHandlersForAction(actionType: ActionTypes): List<ActionHandler> {
        return when(actionType) {
            ActionTypes.NAVIGATE -> listOf(NavigationHandler(navigationManager))
            ActionTypes.INCREMENT_COUNTER, ActionTypes.DECREMENT_COUNTER -> listOf(CounterActionHandler())
        }
    }
}
