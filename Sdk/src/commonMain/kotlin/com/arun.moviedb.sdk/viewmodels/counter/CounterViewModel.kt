package com.arun.moviedb.sdk.viewmodels.counter

import com.arun.moviedb.sdk.viewmodels.ViewModel
import com.arun.moviedb.sdk.viewmodels.ViewModelBuilder
import kotlin.js.JsName

data class CounterViewModel(@JsName("counter") val counter: Long = 0): ViewModel

class CounterViewModelBuilder: ViewModelBuilder<CounterViewModel> {
    override fun build(): CounterViewModel {
        return CounterViewModel(0)
    }
}
