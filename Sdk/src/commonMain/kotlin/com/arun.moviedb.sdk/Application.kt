package com.arun.moviedb.sdk

import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.dispatcher.ActionMapper
import com.arun.moviedb.sdk.dispatcher.actions.Action
import com.arun.moviedb.sdk.repository.TMDBClient
import com.arun.moviedb.sdk.screen.ScreenTypes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class Application: ActionDispatcher {
    private val _mutableAppState = MutableStateFlow(AppState("/", ScreenTypes.COUNTER))
    val appClient: TMDBClient = TMDBClient()
    val appState: StateFlow<AppState> = _mutableAppState

    override fun dispatch(action: Action) {
        val actionDispatcher: ActionDispatcher = this
        CoroutineScope(Dispatchers.Default).launch {
            val screenActionHandlers = ActionMapper.getHandlersForScreen()
            val appActionHandlers = ActionMapper.getHandlersForApp()
            screenActionHandlers.forEach { handler -> handler.handleAction(action, appState.value.screenViewModel, actionDispatcher) }
            appActionHandlers.forEach { handler -> handler.handleAction(action, _mutableAppState, actionDispatcher) }
        }
    }
}
