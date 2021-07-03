package com.arun.moviedb.sdk.viewmodels.home

import com.arun.moviedb.sdk.models.discover.DiscoverResult
import com.arun.moviedb.sdk.viewmodels.ViewModel
import com.arun.moviedb.sdk.viewmodels.ViewModelBuilder

class HomeScreenViewModel(
    val hasDataLoaded: Boolean = false,
    val popularMovies: List<DiscoverResult>? = null,
    val regionalMovies: List<DiscoverResult>? = null,
    val latestMovies: List<DiscoverResult>? = null,
    val popularTvShows: List<DiscoverResult>? = null,
    val latestTvShows: List<DiscoverResult>? = null
): ViewModel

class HomeScreenViewModelBuilder: ViewModelBuilder<HomeScreenViewModel> {
    override fun build(): HomeScreenViewModel {
        return HomeScreenViewModel()
    }
}
