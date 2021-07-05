package com.arun.android.moviedb.screens.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.dispatcher.actions.Action
import com.arun.moviedb.sdk.dispatcher.actions.ActionTypes
import com.arun.moviedb.sdk.viewmodels.home.HomeScreenViewModel

@Composable
fun HomeScreen(viewModel: HomeScreenViewModel, dispatcher: ActionDispatcher) {
    if (!viewModel.hasDataLoaded) {
        Text("Home Screen Data has not loaded")
        dispatcher.dispatch(Action(ActionTypes.LOAD_HOME_SCREEN))
        return
    }
    Text("Home Screen data has loaded with movies: " + viewModel.popularMovies?.size)
}