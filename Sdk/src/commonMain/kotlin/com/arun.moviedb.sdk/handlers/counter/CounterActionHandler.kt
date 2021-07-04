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
        state: AppState,
        dispatcher: ActionDispatcher,
        getMutableState: suspend ((MutableStateFlow<AppState>) -> Unit) -> Unit,
    ) {
        if (state.screenViewModel is CounterViewModel) {
            val counterViewModel = state.screenViewModel
            val currentCount = counterViewModel.counter
            val updatedViewModel: CounterViewModel = when (action.type) {
                ActionTypes.INCREMENT_COUNTER -> counterViewModel.copy(counter = currentCount + 1)
                ActionTypes.DECREMENT_COUNTER -> counterViewModel.copy(counter = currentCount - 1)
                else -> counterViewModel
            }
            getMutableState { mutableState ->
                mutableState.value = mutableState.value.copy(screenViewModel = updatedViewModel)
            }
        }
    }
}
