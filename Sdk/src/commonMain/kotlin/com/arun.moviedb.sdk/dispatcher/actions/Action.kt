package com.arun.moviedb.sdk.dispatcher.actions

open class Action(val type: ActionTypes, val payload: ActionPayload? = null)