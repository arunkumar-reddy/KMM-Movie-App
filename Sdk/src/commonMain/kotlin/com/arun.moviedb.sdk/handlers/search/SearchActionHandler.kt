package com.arun.moviedb.sdk.handlers.search

import com.arun.moviedb.sdk.AppState
import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.dispatcher.actions.Action
import com.arun.moviedb.sdk.handlers.ActionHandler
import com.arun.moviedb.sdk.network.MovieClient
import com.arun.moviedb.sdk.utils.ResponseUtils
import com.arun.moviedb.sdk.viewmodels.search.SearchViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SearchActionHandler: ActionHandler {
    override suspend fun handleAction(
        action: Action,
        state: AppState,
        dispatcher: ActionDispatcher,
        getMutableState: suspend ((MutableStateFlow<AppState>) -> Unit) -> Unit
    ) {
        val viewModel = state.screenViewModel
        if (viewModel is SearchViewModel) {
            viewModel.query?.let { query ->
                viewModel.coroutineScope.launch {
                    val client = MovieClient.getInstance()
                    val movieSearchRequest = async { client.getMoviesForQuery(query) }
                    val tvSearchRequest = async { client.getTvShowsForQuery(query) }

                    val movieSearchResults = ResponseUtils.processResponse(movieSearchRequest.await())
                    val tvSearchResults = ResponseUtils.processResponse(tvSearchRequest.await())
                    val searchViewModel = SearchViewModel(
                        query = query,
                        hasDataLoaded = true,
                        movieSearchResults = ResponseUtils.convertToActionableResults(movieSearchResults),
                        tvSearchResults = ResponseUtils.convertToActionableResults(tvSearchResults)
                    )
                    getMutableState { mutableState ->
                        mutableState.value = mutableState.value.copy(screenViewModel = searchViewModel)
                    }
                }
            }
        }
    }
}
