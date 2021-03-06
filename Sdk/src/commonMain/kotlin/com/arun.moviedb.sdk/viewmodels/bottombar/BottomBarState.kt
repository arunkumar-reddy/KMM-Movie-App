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
    @JsName("selectedIndex")
    val selectedIndex: Int,
    @JsName("bottomBarItems")
    val bottomBarItems: List<BottomBarItem>
)

object BottomBarBuilder {
    private val bottomBarItems = listOf(
        BottomBarItem(title = "Home", screenName = ScreenNames.HOME, action = NavigationAction(NavigationType.FORWARD, ScreenNames.HOME)),
        BottomBarItem(title = "Search", screenName = ScreenNames.SEARCH, action = NavigationAction(NavigationType.FORWARD, ScreenNames.SEARCH)),
        BottomBarItem(title = "Favorites", screenName = ScreenNames.FAVORITES, action = NavigationAction(NavigationType.FORWARD, ScreenNames.FAVORITES))
    )

    fun getBottomBarItems(): List<BottomBarItem> {
        return bottomBarItems
    }
}
