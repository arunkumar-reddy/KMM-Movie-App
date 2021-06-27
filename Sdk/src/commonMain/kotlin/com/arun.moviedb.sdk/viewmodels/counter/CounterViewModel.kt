package com.arun.moviedb.sdk.viewmodels.counter

import com.arun.moviedb.sdk.AppState
import com.arun.moviedb.sdk.viewmodels.ViewModel
import com.arun.moviedb.sdk.viewmodels.ViewModelCreator
import kotlinx.coroutines.flow.MutableStateFlow

data class CounterViewModel(override val appState: AppState, val counter: Long = 0): ViewModel(appState)

class CounterViewModelCreator: ViewModelCreator {
    override fun createViewModel(appState: AppState): MutableStateFlow<ViewModel> {
        return MutableStateFlow(CounterViewModel(appState, 0))
    }
}
