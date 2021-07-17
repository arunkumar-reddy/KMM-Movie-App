package com.arun.moviedb.sdk

import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.dispatcher.ActionMapper
import com.arun.moviedb.sdk.dispatcher.actions.Action
import com.arun.moviedb.sdk.dispatcher.actions.navigation.NavigationAction
import com.arun.moviedb.sdk.dispatcher.actions.navigation.NavigationType
import com.arun.moviedb.sdk.screen.ScreenNames
import com.arun.moviedb.sdk.viewmodels.appbar.AppBarState
import com.arun.moviedb.sdk.viewmodels.bottombar.BottomBarBuilder
import com.arun.moviedb.sdk.viewmodels.bottombar.BottomBarState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.js.JsExport

@JsExport
class Application(private val initState: AppState? = null): ActionDispatcher {
    private val _mutableAppState = MutableStateFlow(AppState(
        appBarState = AppBarState(),
        bottomBarState = BottomBarState(showBottomBar = true, bottomBarItems = BottomBarBuilder.getBottomBarItems())
    ))
    private val actionHandlerLock = Mutex()
    val appState: StateFlow<AppState> = _mutableAppState

    init {
        initState?.let {
            _mutableAppState.value = initState
        } ?: dispatch(NavigationAction(NavigationType.FORWARD, ScreenNames.DEFAULT))
    }

    override fun dispatch(action: Action) {
        val actionDispatcher: ActionDispatcher = this
        CoroutineScope(Dispatchers.Main).launch {
            val actionHandlers = ActionMapper.getHandlersForAction(action.type)
            actionHandlers.forEach { handler ->
                handler.handleAction(action, _mutableAppState.value, actionDispatcher) {
                    getMutableStateWithLock(it)
                }
            }
        }
    }

    private suspend fun getMutableStateWithLock(updateState: (MutableStateFlow<AppState>) -> Unit) {
        actionHandlerLock.withLock {
            updateState(_mutableAppState)
        }
    }
}
