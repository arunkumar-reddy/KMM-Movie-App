package com.arun.moviedb.sdk.viewmodels.search

import com.arun.moviedb.sdk.models.actionable.ActionableDiscoverResult
import com.arun.moviedb.sdk.viewmodels.ViewModel
import kotlin.js.JsName

class SearchViewModel(
    @JsName("query")
    val query: String,
    @JsName("hasDataLoaded")
    val hasDataLoaded: Boolean = false,
    @JsName("searchResults")
    val searchResults: List<ActionableDiscoverResult>? = null
): ViewModel
