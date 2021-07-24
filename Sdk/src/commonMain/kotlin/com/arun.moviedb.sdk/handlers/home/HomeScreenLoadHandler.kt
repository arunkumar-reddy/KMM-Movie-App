package com.arun.moviedb.sdk.handlers.home

import com.arun.moviedb.sdk.AppState
import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.dispatcher.actions.Action
import com.arun.moviedb.sdk.handlers.ActionHandler
import com.arun.moviedb.sdk.network.MovieClient
import com.arun.moviedb.sdk.utils.ResponseUtils
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
                val popularMoviesRequest = async { client.getMostPopularMovies() }
                val regionalMoviesRequest = async { client.getMoviesByRegion() }
                val latestMoviesRequest = async { client.getLatestMovies() }
                val popularTvShowsRequest = async { client.getMostPopularTvShows() }
                val latestTvShowsRequest = async { client.getLatestTvShows() }

                val popularMovies = ResponseUtils.processResponse(popularMoviesRequest.await())
                val latestMovies = ResponseUtils.processResponse(latestMoviesRequest.await())
                val regionalMovies = ResponseUtils.processResponse(regionalMoviesRequest.await())
                val popularTvShows = ResponseUtils.processResponse(popularTvShowsRequest.await())
                val latestTvShows = ResponseUtils.processResponse(latestTvShowsRequest.await())

                val homeScreenViewModel = HomeScreenViewModel(
                    true,
                    popularMovies = ResponseUtils.convertToActionableResults(popularMovies),
                    regionalMovies = ResponseUtils.convertToActionableResults(regionalMovies),
                    latestMovies = ResponseUtils.convertToActionableResults(latestMovies),
                    popularTvShows = ResponseUtils.convertToActionableResults(popularTvShows),
                    latestTvShows = ResponseUtils.convertToActionableResults(latestTvShows)
                )
                getMutableState { mutableState ->
                    mutableState.value = mutableState.value.copy(screenViewModel = homeScreenViewModel)
                }
            }
        }
    }
}
