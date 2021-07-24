package com.arun.moviedb.sdk.dispatcher

import com.arun.moviedb.sdk.dispatcher.actions.Action
import com.arun.moviedb.sdk.dispatcher.actions.ActionTypes
import com.arun.moviedb.sdk.handlers.ActionHandler
import com.arun.moviedb.sdk.handlers.counter.CounterActionHandler
import com.arun.moviedb.sdk.handlers.home.HomeScreenLoadHandler
import com.arun.moviedb.sdk.handlers.navigation.NavigationHandler
import com.arun.moviedb.sdk.handlers.search.SearchActionHandler
import com.arun.moviedb.sdk.navigation.NavigationManager

object ActionMapper {
    private val navigationManager = NavigationManager()

    fun getHandlersForAction(actionType: ActionTypes): List<ActionHandler> {
        return when(actionType) {
            ActionTypes.NAVIGATE -> listOf(NavigationHandler(navigationManager))
            ActionTypes.INCREMENT_COUNTER, ActionTypes.DECREMENT_COUNTER -> listOf(CounterActionHandler())
            ActionTypes.LOAD_HOME_SCREEN -> listOf(HomeScreenLoadHandler())
            ActionTypes.SEARCH_QUERY -> listOf(SearchActionHandler())
        }
    }
}
