package com.arun.moviedb.sdk.handlers

import com.arun.moviedb.sdk.dispatcher.actions.Action
import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.viewmodels.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

interface ScreenActionHandler {
    suspend fun handleAction(action: Action, viewModel: MutableStateFlow<ViewModel>?, dispatcher: ActionDispatcher)
}
