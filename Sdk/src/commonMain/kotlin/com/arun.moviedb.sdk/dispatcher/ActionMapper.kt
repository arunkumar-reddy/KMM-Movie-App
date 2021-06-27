package com.arun.moviedb.sdk.dispatcher

import com.arun.moviedb.sdk.handlers.AppActionHandler
import com.arun.moviedb.sdk.handlers.ScreenActionHandler
import com.arun.moviedb.sdk.handlers.counter.CounterActionHandler
import com.arun.moviedb.sdk.navigation.NavigationManager

object ActionMapper {
    fun getHandlersForScreen(): List<ScreenActionHandler> {
        return listOf(
            CounterActionHandler()
        )
    }

    fun getHandlersForApp(): List<AppActionHandler> {
        return listOf(
            NavigationManager()
        )
    }
}
