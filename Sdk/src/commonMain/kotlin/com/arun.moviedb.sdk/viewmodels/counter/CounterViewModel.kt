package com.arun.moviedb.sdk.viewmodels.counter

import com.arun.moviedb.sdk.dispatcher.actions.Action
import com.arun.moviedb.sdk.dispatcher.actions.ActionTypes
import com.arun.moviedb.sdk.dispatcher.actions.navigation.NavigationAction
import com.arun.moviedb.sdk.dispatcher.actions.navigation.NavigationType
import com.arun.moviedb.sdk.screen.ScreenNames
import com.arun.moviedb.sdk.viewmodels.BaseViewModel
import kotlin.js.JsName

data class CounterViewModel(
    @JsName("counter")
    val counter: Long = 0,
    @JsName("incrementAction")
    val incrementAction: Action = Action(ActionTypes.INCREMENT_COUNTER),
    @JsName("decrementAction")
    val decrementAction: Action = Action(ActionTypes.DECREMENT_COUNTER),
    @JsName("submitAction")
    val submitAction: Action = NavigationAction(NavigationType.FORWARD, ScreenNames.HOME),
): BaseViewModel()
