package com.arun.moviedb.sdk.viewmodels.bottombar

import com.arun.moviedb.sdk.dispatcher.actions.Action
import com.arun.moviedb.sdk.dispatcher.actions.navigation.NavigationAction
import com.arun.moviedb.sdk.dispatcher.actions.navigation.NavigationType
import com.arun.moviedb.sdk.screen.ScreenNames

data class BottomBarItem(
    val title: String,
    val icon: String? = null,
    val screenName: String,
    val action: Action,
    val selected: Boolean = false
)

data class BottomBarState(
    val showBottomBar: Boolean,
    val bottomBarItems: List<BottomBarItem>
)

object BottomBarBuilder {
    private val bottomBarItems = listOf<BottomBarItem>(
        BottomBarItem(title = "Home", screenName = ScreenNames.HOME, action = NavigationAction(NavigationType.REPLACE, ScreenNames.HOME)),
        BottomBarItem(title = "Search", screenName = ScreenNames.HOME, action = NavigationAction(NavigationType.REPLACE, ScreenNames.SEARCH)),
        BottomBarItem(title = "Favorites", screenName = ScreenNames.HOME, action = NavigationAction(NavigationType.REPLACE, ScreenNames.FAVORITES))
    )

    fun getBottomBarItems(): List<BottomBarItem> {
        return bottomBarItems
    }
}
