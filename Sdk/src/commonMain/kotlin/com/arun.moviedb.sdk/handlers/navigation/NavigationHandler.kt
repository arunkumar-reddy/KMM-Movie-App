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

class NavigationHandler(private val navigator: Navigator): ActionHandler {
    override suspend fun handleAction(
        action: Action,
        state: AppState,
        dispatcher: ActionDispatcher,
        getMutableState: suspend ((MutableStateFlow<AppState>) -> Unit) -> Unit
    ) {
        if (action is NavigationAction) {
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
            getMutableState { mutableState ->
                mutableState.value = mutableState.value.copy(navigationState = currentScreen, screenViewModel = viewModel)
            }
        }
    }
}
