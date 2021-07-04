package com.arun.moviedb.sdk.handlers.home

import com.arun.moviedb.sdk.AppState
import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.dispatcher.actions.Action
import com.arun.moviedb.sdk.handlers.ActionHandler
import com.arun.moviedb.sdk.models.discover.DiscoverResponse
import com.arun.moviedb.sdk.models.discover.DiscoverResult
import com.arun.moviedb.sdk.network.MovieClient
import com.arun.moviedb.sdk.viewmodels.home.HomeScreenViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeScreenLoadHandler: ActionHandler {
    override suspend fun handleAction(
        action: Action,
        state: AppState,
        dispatcher: ActionDispatcher,
        getMutableState: suspend ((MutableStateFlow<AppState>) -> Unit) -> Unit
    ) {
        if (state.screenViewModel is HomeScreenViewModel) {
            CoroutineScope(Dispatchers.Default).launch {
                val client = MovieClient.getInstance()
                val popularMoviesData = async { client.getMostPopularMovies() }
                val regionalMoviesData = async { client.getMoviesByRegion() }
                val latestMoviesData = async { client.getLatestMovies() }
                val popularTvShowsData = async { client.getMostPopularTvShows() }
                val latestTvShowsData = async { client.getLatestTvShows() }

                val popularMovies = processResponse(popularMoviesData.await())
                val latestMovies = processResponse(latestMoviesData.await())
                val regionalMovies = processResponse(regionalMoviesData.await())
                val popularTvShows = processResponse(popularTvShowsData.await())
                val latestTvShows = processResponse(latestTvShowsData.await())

                getMutableState { mutableState ->
                    val homeScreenViewModel = HomeScreenViewModel(
                        true,
                        popularMovies = popularMovies,
                        regionalMovies = regionalMovies,
                        latestMovies = latestMovies,
                        popularTvShows = popularTvShows,
                        latestTvShows = latestTvShows
                    )
                    mutableState.value = mutableState.value.copy(screenViewModel = homeScreenViewModel)
                }
            }
        }
    }

    private fun processResponse(response: DiscoverResponse): List<DiscoverResult>? {
        return when(response) {
            is DiscoverResponse.Success -> response.success.results
            is DiscoverResponse.Error -> null
        }
    }
}
