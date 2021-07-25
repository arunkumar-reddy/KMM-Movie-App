package com.arun.android.moviedb.screens.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arun.android.moviedb.components.search.SearchInputWidget
import com.arun.android.moviedb.components.search.SearchResultsWidget
import com.arun.android.moviedb.screens.home.Loader
import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.dispatcher.actions.Action
import com.arun.moviedb.sdk.dispatcher.actions.ActionTypes
import com.arun.moviedb.sdk.viewmodels.search.SearchViewModel

@Composable
fun SearchScreen(viewModel: SearchViewModel, dispatcher: ActionDispatcher) {
    Column(modifier = Modifier.fillMaxSize()) {
        SearchInputWidget(viewModel.query ?: "", dispatcher)
        viewModel.query?.let { query ->
            if (!viewModel.hasDataLoaded) {
                Row(modifier = Modifier.align(Alignment.CenterHorizontally), verticalAlignment = Alignment.CenterVertically) {
                    Loader()
                }
                dispatcher.dispatch(Action(ActionTypes.SEARCH_QUERY))
            } else {
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    viewModel.movieSearchResults?.let {
                        SearchResultsWidget(query, it)
                    }
                    viewModel.tvSearchResults?.let {
                        SearchResultsWidget(query, it)
                    }
                }
            }
        }
    }
}
