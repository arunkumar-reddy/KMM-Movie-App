package com.arun.moviedb.sdk.viewmodels

import com.arun.moviedb.sdk.AppState

data class CounterViewModel(override val appState: AppState, val counter: Long = 0): ViewModel(appState)