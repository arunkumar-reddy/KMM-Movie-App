package com.arun.moviedb.sdk.handlers

import com.arun.moviedb.sdk.AppState
import com.arun.moviedb.sdk.dispatcher.actions.Action
import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import kotlinx.coroutines.flow.MutableStateFlow

interface ActionHandler {
    suspend fun handleAction(
        action: Action,
        state: AppState,
        dispatcher: ActionDispatcher,
        getMutableState: suspend ((MutableStateFlow<AppState>) -> Unit) -> Unit
    )
}
