package com.arun.moviedb.sdk.viewmodels

interface ViewModel

interface ViewModelBuilder<T> {
    fun build(): T
}
