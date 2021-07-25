package com.arun.android.moviedb.screens

import androidx.compose.runtime.Composable
import com.arun.android.moviedb.screens.counter.CounterScreen
import com.arun.android.moviedb.screens.home.HomeScreen
import com.arun.android.moviedb.screens.search.SearchScreen
import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.viewmodels.ViewModel
import com.arun.moviedb.sdk.viewmodels.counter.CounterViewModel
import com.arun.moviedb.sdk.viewmodels.home.HomeScreenViewModel
import com.arun.moviedb.sdk.viewmodels.search.SearchViewModel

@Composable
fun Screen(viewModel: ViewModel, dispatcher: ActionDispatcher) {
    when(viewModel) {
        is CounterViewModel -> {
            CounterScreen(viewModel, dispatcher)
        }
        is HomeScreenViewModel -> {
            HomeScreen(viewModel, dispatcher)
        }
        is SearchViewModel -> {
            SearchScreen(viewModel, dispatcher)
        }
        else -> {}
    }
}
