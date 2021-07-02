package com.arun.moviedb.sdk.handlers.counter

import com.arun.moviedb.sdk.AppState
import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.dispatcher.actions.Action
import com.arun.moviedb.sdk.dispatcher.actions.ActionTypes
import com.arun.moviedb.sdk.handlers.ActionHandler
import com.arun.moviedb.sdk.viewmodels.counter.CounterViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class CounterActionHandler: ActionHandler {
    override suspend fun handleAction(
        action: Action,
        state: MutableStateFlow<AppState>,
        dispatcher: ActionDispatcher
    ) {
        if (state.value.screenViewModel is CounterViewModel) {
            val counterViewModel = state.value.screenViewModel as CounterViewModel
            val currentCount = counterViewModel.counter
            when (action.type) {
                ActionTypes.INCREMENT_COUNTER -> {
                    state.value = state.value.copy(screenViewModel = counterViewModel.copy(counter = currentCount + 1))
                }
                ActionTypes.DECREMENT_COUNTER -> {
                    state.value = state.value.copy(screenViewModel = counterViewModel.copy(counter = currentCount - 1))
                }
                else -> {}
            }
        }
    }
}
