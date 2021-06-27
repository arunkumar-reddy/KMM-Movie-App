package com.arun.moviedb.sdk.dispatcher

import com.arun.moviedb.sdk.dispatcher.actions.Action

interface ActionDispatcher {
    fun dispatch(action: Action)
}
