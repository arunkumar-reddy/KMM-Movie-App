package com.arun.moviedb.sdk.viewmodels.bottombar

import com.arun.moviedb.sdk.dispatcher.actions.Action
import com.arun.moviedb.sdk.dispatcher.actions.navigation.NavigationAction
import com.arun.moviedb.sdk.dispatcher.actions.navigation.NavigationType
import com.arun.moviedb.sdk.screen.ScreenNames
import kotlin.js.JsName

data class BottomBarItem(
    @JsName("title")
    val title: String,
    @JsName("icon")
    val icon: String? = null,
    @JsName("screenName")
    val screenName: String,
    @JsName("action")
    val action: Action,
    @JsName("selected")
    val selected: Boolean = false
)

data class BottomBarState(
    @JsName("showBottomBar")
    val showBottomBar: Boolean,
    @JsName("bottomBarItems")
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
