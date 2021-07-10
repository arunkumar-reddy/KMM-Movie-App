package com.arun.moviedb.sdk.handlers.navigation

import com.arun.moviedb.sdk.AppState
import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.dispatcher.actions.Action
import com.arun.moviedb.sdk.dispatcher.actions.navigation.NavigationAction
import com.arun.moviedb.sdk.dispatcher.actions.navigation.NavigationType
import com.arun.moviedb.sdk.handlers.ActionHandler
import com.arun.moviedb.sdk.navigation.Navigator
import com.arun.moviedb.sdk.navigation.router.Router
import com.arun.moviedb.sdk.viewmodels.bottombar.BottomBarBuilder
import kotlinx.coroutines.flow.MutableStateFlow

class NavigationHandler(private val navigator: Navigator): ActionHandler {
    override suspend fun handleAction(
        action: Action,
        state: AppState,
        dispatcher: ActionDispatcher,
        getMutableState: suspend ((MutableStateFlow<AppState>) -> Unit) -> Unit
    ) {
        if (action is NavigationAction) {
            when (action.navigationType) {
                NavigationType.FORWARD -> {
                    action.screenName?.let { navigator.navigateTo(it) }
                }
                NavigationType.BACK -> {
                    navigator.goBack()
                }
                NavigationType.REPLACE -> {
                    action.screenName?.let { navigator.replaceAndNavigateTo(it) }
                }
            }
            navigator.getCurrentScreen()?.let { currentScreen ->
                val viewModel = Router.getViewModelForScreen(currentScreen.screenType)
                val showBottomBar = showBottomBar(currentScreen.screenName)
                getMutableState { mutableState ->
                    mutableState.value = mutableState.value.copy(
                        navigationState = currentScreen,
                        screenViewModel = viewModel,
                        bottomBarState = mutableState.value.bottomBarState?.copy(showBottomBar = showBottomBar)
                    )
                }
            }
        }
    }

    private fun showBottomBar(screenName: String): Boolean {
        for (bottomBarItem in BottomBarBuilder.getBottomBarItems()) {
            if (screenName == bottomBarItem.screenName) return true
        }
        return false
    }
}
