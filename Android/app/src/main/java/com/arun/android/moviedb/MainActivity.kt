package com.arun.android.moviedb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.lifecycleScope
import com.arun.android.moviedb.screens.CounterScreen
import com.arun.moviedb.sdk.AppState
import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.viewmodels.CounterViewModel
import com.arun.moviedb.sdk.viewmodels.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launchWhenCreated {
            setContent {
                Application()
            }
        }
    }
}

@Composable
fun Application() {
    val application = com.arun.moviedb.sdk.Application()
    val state: State<AppState> = application.appState.collectAsState()
    state.value.screenViewModel?.let { viewModel ->
        Screen(viewModel, application)
    }
}

@Composable
fun Screen(viewModelFlow: MutableStateFlow<ViewModel>, actionDispatcher: ActionDispatcher) {
    val state = viewModelFlow.collectAsState()

    when(state.value) {
        is CounterViewModel -> {
            CounterScreen(state.value as CounterViewModel, actionDispatcher)
        }
        else -> {}
    }
}
