package com.arun.moviedb.sdk.viewmodels.home

import com.arun.moviedb.sdk.dispatcher.actions.Action
import com.arun.moviedb.sdk.dispatcher.actions.ActionTypes
import com.arun.moviedb.sdk.models.actionable.ActionableDiscoverResult
import com.arun.moviedb.sdk.viewmodels.ViewModel
import kotlin.js.JsName

class HomeScreenViewModel(
    @JsName("hasDataLoaded")
    val hasDataLoaded: Boolean = false,
    @JsName("loadAction")
    val loadAction: Action = Action(ActionTypes.LOAD_HOME_SCREEN),
    @JsName("popularMovies")
    val popularMovies: List<ActionableDiscoverResult>? = null,
    @JsName("regionalMovies")
    val regionalMovies: List<ActionableDiscoverResult>? = null,
    @JsName("latestMovies")
    val latestMovies: List<ActionableDiscoverResult>? = null,
    @JsName("popularTvShows")
    val popularTvShows: List<ActionableDiscoverResult>? = null,
    @JsName("latestTvShows")
    val latestTvShows: List<ActionableDiscoverResult>? = null
): ViewModel
