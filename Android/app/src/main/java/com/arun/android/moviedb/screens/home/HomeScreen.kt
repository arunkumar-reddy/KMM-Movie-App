package com.arun.android.moviedb.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arun.android.moviedb.screens.discover.DiscoverWidget
import com.arun.android.moviedb.utils.ColorUtils
import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.dispatcher.actions.Action
import com.arun.moviedb.sdk.dispatcher.actions.ActionTypes
import com.arun.moviedb.sdk.network.MovieClient
import com.arun.moviedb.sdk.viewmodels.home.HomeScreenViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(viewModel: HomeScreenViewModel, dispatcher: ActionDispatcher) {
    Column(modifier = Modifier.fillMaxSize()) {
        if (!viewModel.hasDataLoaded) {
            Row(modifier = Modifier.align(Alignment.CenterHorizontally), verticalAlignment = Alignment.CenterVertically) {
                Loader()
            }
            dispatcher.dispatch(Action(ActionTypes.LOAD_HOME_SCREEN))
        } else {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                viewModel.popularMovies?.let {
                    DiscoverWidget(title = "Popular Movies", data = it)
                }
                viewModel.latestMovies?.let {
                    DiscoverWidget(title = "Latest Movies", data = it)
                }
                viewModel.popularTvShows?.let {
                    DiscoverWidget(title = "Popular Tv Shows", data = it)
                }
                viewModel.latestTvShows?.let {
                    DiscoverWidget(title = "Latest Tv Shows", data = it)
                }
                viewModel.regionalMovies?.let {
                    DiscoverWidget(title = "Regional Movies", data = it)
                }
            }
        }
    }
}

@Composable
fun Loader() {
    CircularProgressIndicator(
        modifier = Modifier.size(40.dp),
        color = ColorUtils.getColorFromHex("#FFC107")
    )
}