package com.arun.moviedb.sdk.handlers.counter

import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.dispatcher.actions.Action
import com.arun.moviedb.sdk.dispatcher.actions.ActionTypes
import com.arun.moviedb.sdk.handlers.ScreenActionHandler
import com.arun.moviedb.sdk.viewmodels.CounterViewModel
import com.arun.moviedb.sdk.viewmodels.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class CounterActionHandler: ScreenActionHandler {
    override suspend fun handleAction(
        action: Action,
        viewModel: MutableStateFlow<ViewModel>?,
        dispatcher: ActionDispatcher
    ) {
        if (viewModel?.value is CounterViewModel) {
            val counterViewModel = viewModel.value as CounterViewModel
            val currentCount = counterViewModel.counter
            when (action.type) {
                ActionTypes.INCREMENT_COUNTER -> {
                    val updatedState = counterViewModel.copy(counterViewModel.appState, currentCount + 1)
                    viewModel.value = updatedState
                }
                ActionTypes.DECREMENT_COUNTER -> {
                    val updatedState = counterViewModel.copy(counterViewModel.appState, currentCount - 1)
                    viewModel.value = updatedState
                }
                else -> {}
            }
        }
    }
}
