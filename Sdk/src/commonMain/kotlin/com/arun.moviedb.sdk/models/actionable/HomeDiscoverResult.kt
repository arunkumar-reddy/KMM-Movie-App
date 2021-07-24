package com.arun.moviedb.sdk.models.actionable

import com.arun.moviedb.sdk.dispatcher.actions.navigation.NavigationAction
import com.arun.moviedb.sdk.models.discover.DiscoverResult
import kotlin.js.JsName

data class ActionableDiscoverResult (
    @JsName("result")
    val result: DiscoverResult,
    @JsName("action")
    val action: NavigationAction
)
