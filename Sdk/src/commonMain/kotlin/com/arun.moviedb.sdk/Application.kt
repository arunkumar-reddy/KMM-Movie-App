package com.arun.moviedb.sdk

import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.dispatcher.ActionMapper
import com.arun.moviedb.sdk.dispatcher.actions.Action
import com.arun.moviedb.sdk.dispatcher.actions.navigation.NavigationAction
import com.arun.moviedb.sdk.dispatcher.actions.navigation.NavigationPayload
import com.arun.moviedb.sdk.dispatcher.actions.navigation.NavigationType
import com.arun.moviedb.sdk.screen.ScreenNames
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class Application: ActionDispatcher {
    private val _mutableAppState = MutableStateFlow(AppState())
    val appState: StateFlow<AppState> = _mutableAppState

    init {
        dispatch(NavigationAction(NavigationPayload(NavigationType.FORWARD, ScreenNames.DEFAULT)))
    }

    override fun dispatch(action: Action) {
        val actionDispatcher: ActionDispatcher = this
        CoroutineScope(Dispatchers.Default).launch {
            val screenActionHandlers = ActionMapper.getHandlersForScreen()
            val appActionHandlers = ActionMapper.getHandlersForApp()
            screenActionHandlers.forEach { handler -> handler.handleAction(action, appState.value.currentScreenViewModel, actionDispatcher) }
            appActionHandlers.forEach { handler -> handler.handleAction(action, _mutableAppState, actionDispatcher) }
        }
    }
}
