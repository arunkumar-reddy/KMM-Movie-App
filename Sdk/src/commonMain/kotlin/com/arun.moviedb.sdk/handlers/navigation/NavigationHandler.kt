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
import kotlinx.coroutines.cancel
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
                val viewModel = Router.getViewModelForScreen(currentScreen.screenType, currentScreen.screenName)
                val showBottomBar = showBottomBar(currentScreen.screenName)
                state.screenViewModel?.coroutineScope?.cancel("viewModel scope cancelled as user has navigated away from the page")
                getMutableState { mutableState ->
                    mutableState.value = mutableState.value.copy(
                        navigationState = currentScreen,
                        screenViewModel = viewModel,
                        bottomBarState = mutableState.value.bottomBarState?.copy(showBottomBar = showBottomBar.first, selectedIndex = showBottomBar.second)
                    )
                }
            }
        }
    }

    private fun showBottomBar(screenName: String): Pair<Boolean, Int> {
        val bottomBarItems = BottomBarBuilder.getBottomBarItems()
        for (i in bottomBarItems.indices) {
            if (screenName == bottomBarItems[i].screenName) return Pair(true, i)
        }
        return Pair(false, -1)
    }
}
