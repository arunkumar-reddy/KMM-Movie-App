package com.arun.moviedb.sdk.viewmodels.home

import com.arun.moviedb.sdk.models.discover.DiscoverResult
import com.arun.moviedb.sdk.viewmodels.ViewModel
import com.arun.moviedb.sdk.viewmodels.ViewModelBuilder
import kotlin.js.JsName

class HomeScreenViewModel(
    @JsName("hasDataLoaded")
    val hasDataLoaded: Boolean = false,
    @JsName("popularMovies")
    val popularMovies: List<DiscoverResult>? = null,
    @JsName("regionalMovies")
    val regionalMovies: List<DiscoverResult>? = null,
    @JsName("latestMovies")
    val latestMovies: List<DiscoverResult>? = null,
    @JsName("popularTvShows")
    val popularTvShows: List<DiscoverResult>? = null,
    @JsName("latestTvShows")
    val latestTvShows: List<DiscoverResult>? = null
): ViewModel

class HomeScreenViewModelBuilder: ViewModelBuilder<HomeScreenViewModel> {
    override fun build(): HomeScreenViewModel {
        return HomeScreenViewModel()
    }
}
