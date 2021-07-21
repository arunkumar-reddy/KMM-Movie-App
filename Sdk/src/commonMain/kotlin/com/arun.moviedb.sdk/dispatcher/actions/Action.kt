package com.arun.moviedb.sdk.dispatcher.actions

open class Action (val type: ActionTypes)

open class ActionBuilder {
    open fun buildAction(type: ActionTypes, jsObject: dynamic = null): Action? {
        return Action(type)
    }
}
