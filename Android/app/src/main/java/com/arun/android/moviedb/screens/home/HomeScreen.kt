package com.arun.android.moviedb.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arun.android.moviedb.components.discover.DiscoverWidget
import com.arun.android.moviedb.utils.ColorUtils
import com.arun.android.moviedb.utils.Colors
import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.models.actionable.ActionableDiscoverResult
import com.arun.moviedb.sdk.viewmodels.home.HomeScreenViewModel

@Composable
fun HomeScreen(viewModel: HomeScreenViewModel, dispatcher: ActionDispatcher) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Colors.appBlack)) {
        if (!viewModel.hasDataLoaded) {
            Column(modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.CenterHorizontally), verticalArrangement = Arrangement.Center ) {
                Loader()
            }
            dispatcher.dispatch(viewModel.loadAction)
        } else {
            val items = getDiscoverWidgetItems(viewModel)
            LazyColumn(modifier = Modifier.padding(bottom = 8.dp)) {
                items(items) { item ->
                    DiscoverWidget(title = item.first, data = item.second)
                }
            }
        }
    }
}

fun getDiscoverWidgetItems(viewModel: HomeScreenViewModel): List<Pair<String, List<ActionableDiscoverResult>>> {
    val items = mutableListOf<Pair<String, List<ActionableDiscoverResult>>>()
    viewModel.popularMovies?.let {
        items.add(Pair("Popular Movies", it))
    }
    viewModel.latestMovies?.let {
        items.add(Pair("Latest Movies", it))
    }
    viewModel.popularTvShows?.let {
        items.add(Pair("Popular Tv Shows", it))
    }
    viewModel.latestTvShows?.let {
        items.add(Pair("Latest Tv Shows", it))
    }
    viewModel.regionalMovies?.let {
        items.add(Pair("Regional Movies", it))
    }
    return items
}

@Composable
fun Loader() {
    CircularProgressIndicator(
        modifier = Modifier.size(40.dp),
        color = ColorUtils.getColorFromHex("#FFC107")
    )
}