package com.arun.moviedb.sdk.dispatcher.actions

open class Action(val type: ActionTypes, open val payload: ActionPayload? = null)