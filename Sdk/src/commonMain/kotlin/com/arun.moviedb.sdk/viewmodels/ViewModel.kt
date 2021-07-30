package com.arun.moviedb.sdk.viewmodels

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

interface ViewModel {
    val coroutineScope: CoroutineScope
}

open class BaseViewModel(
    override val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Default)
): ViewModel
