package com.arun.moviedb.sdk.viewmodels

import com.arun.moviedb.sdk.AppState
import kotlinx.coroutines.flow.MutableStateFlow

open class ViewModel(protected open val appState: AppState)

interface ViewModelCreator {
    fun createViewModel(appState: AppState): MutableStateFlow<ViewModel>
}
