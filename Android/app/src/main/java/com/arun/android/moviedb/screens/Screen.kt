package com.arun.android.moviedb.screens

import androidx.compose.runtime.Composable
import com.arun.android.moviedb.screens.counter.CounterScreen
import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.viewmodels.ViewModel
import com.arun.moviedb.sdk.viewmodels.counter.CounterViewModel

@Composable
fun Screen(viewModel: ViewModel, actionDispatcher: ActionDispatcher) {
    when(viewModel) {
        is CounterViewModel -> {
            CounterScreen(viewModel, actionDispatcher)
        }
        else -> {}
    }
}
