package com.arun.moviedb.sdk.viewmodels.search

import com.arun.moviedb.sdk.models.actionable.ActionableDiscoverResult
import com.arun.moviedb.sdk.viewmodels.ViewModel
import kotlin.js.JsName

class SearchViewModel(
    @JsName("query")
    val query: String,
    @JsName("hasDataLoaded")
    val hasDataLoaded: Boolean = false,
    @JsName("showMovieToggle")
    val showMovieToggle: Boolean = true,
    @JsName("movieSearchResults")
    val movieSearchResults: List<ActionableDiscoverResult>? = null,
    @JsName("tvSearchResults")
    val tvSearchResults: List<ActionableDiscoverResult>? = null
): ViewModel
