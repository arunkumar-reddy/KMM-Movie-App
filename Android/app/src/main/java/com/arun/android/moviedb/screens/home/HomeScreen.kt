package com.arun.android.moviedb.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arun.android.moviedb.components.discover.DiscoverWidget
import com.arun.android.moviedb.utils.ColorUtils
import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.viewmodels.home.HomeScreenViewModel

@Composable
fun HomeScreen(viewModel: HomeScreenViewModel, dispatcher: ActionDispatcher) {
    Column(modifier = Modifier.fillMaxSize()) {
        if (!viewModel.hasDataLoaded) {
            Column(modifier = Modifier.fillMaxHeight().align(Alignment.CenterHorizontally), verticalArrangement = Arrangement.Center ) {
                Loader()
            }
            dispatcher.dispatch(viewModel.loadAction)
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