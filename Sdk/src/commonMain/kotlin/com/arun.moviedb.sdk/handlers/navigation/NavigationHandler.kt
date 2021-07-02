package com.arun.moviedb.sdk.handlers.navigation

import com.arun.moviedb.sdk.AppState
import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.dispatcher.actions.Action
import com.arun.moviedb.sdk.dispatcher.actions.navigation.NavigationAction
import com.arun.moviedb.sdk.dispatcher.actions.navigation.NavigationType
import com.arun.moviedb.sdk.handlers.ActionHandler
import com.arun.moviedb.sdk.navigation.Navigator
import com.arun.moviedb.sdk.navigation.router.Router
import kotlinx.coroutines.flow.MutableStateFlow

class NavigationHandler(val navigator: Navigator): ActionHandler {
    override suspend fun handleAction(
        action: Action,
        state: MutableStateFlow<AppState>,
        dispatcher: ActionDispatcher
    ) {
        if (action is NavigationAction) {
            val appState = state.value
            when (action.payload.navigationType) {
                NavigationType.FORWARD -> {
                    action.payload.screenName?.let { navigator.navigateTo(it) }
                }
                NavigationType.BACK -> {
                    navigator.goBack()
                }
                NavigationType.REPLACE -> {
                    action.payload.screenName?.let { navigator.replaceAndNavigateTo(it) }
                }
            }
            val currentScreen = navigator.getCurrentScreen()
            val viewModel = Router.getViewModelForScreen(currentScreen.screenType)
            state.value = appState.copy(navigationState = currentScreen, screenViewModel = viewModel)
        }
    }
}
