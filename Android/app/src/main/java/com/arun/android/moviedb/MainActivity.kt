package com.arun.android.moviedb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.lifecycleScope
import com.arun.android.moviedb.screens.Screen
import com.arun.moviedb.sdk.AppState
import com.arun.moviedb.sdk.Application

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launchWhenCreated {
            setContent {
                App(Application())
            }
        }
    }
}

@Composable
fun App(application: Application) {
    val state: State<AppState> = application.appState.collectAsState()
    state.value.screenViewModel?.let { viewModel ->
        Screen(viewModel, application)
    }
}

