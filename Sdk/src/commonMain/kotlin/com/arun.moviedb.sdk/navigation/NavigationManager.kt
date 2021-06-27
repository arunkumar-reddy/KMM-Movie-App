package com.arun.moviedb.sdk.navigation

import com.arun.moviedb.sdk.AppState
import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.dispatcher.actions.Action
import com.arun.moviedb.sdk.dispatcher.actions.navigation.NavigationAction
import com.arun.moviedb.sdk.dispatcher.actions.navigation.NavigationType
import com.arun.moviedb.sdk.handlers.AppActionHandler
import com.arun.moviedb.sdk.navigation.router.Router
import kotlinx.coroutines.flow.MutableStateFlow

class NavigationManager: Navigator, AppActionHandler {
    private val navigationStack: ArrayDeque<NavigationState> = ArrayDeque()

    override fun navigateTo(screenName: String) {
        val screenType = Router.getScreenType(screenName)
        navigationStack.add(NavigationState(screenName, screenType))
    }

    override fun goBack() {
        navigationStack.removeLast()
    }

    override fun replaceAndNavigateTo(screenName: String) {
        val screenType = Router.getScreenType(screenName)
        navigationStack.removeLast()
        navigationStack.add(NavigationState(screenName, screenType))
    }

    override fun getCurrentScreen(): NavigationState {
        return navigationStack.last()
    }

    override suspend fun handleAction(
        action: Action,
        state: MutableStateFlow<AppState>,
        dispatcher: ActionDispatcher
    ) {
        if (action is NavigationAction) {
            val appState = state.value
            when (action.payload.navigationType) {
                NavigationType.FORWARD -> {
                    action.payload.screenName?.let { navigateTo(it) }
                }
                NavigationType.BACK -> {
                    goBack()
                }
                NavigationType.REPLACE -> {
                    action.payload.screenName?.let { replaceAndNavigateTo(it) }
                }
            }
            val viewModel = Router.getViewModelForScreen(appState, getCurrentScreen().screenType)
            state.value = appState.copy(getCurrentScreen(), viewModel)
        }
    }
}
