package com.arun.android.moviedb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.arun.android.moviedb.components.appbar.AppBar
import com.arun.android.moviedb.components.bottombar.BottomBar
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
    Column(modifier = Modifier.fillMaxSize()) {
        state.value.appBarState?.let { appBar ->
            Column(modifier = Modifier.weight(1f)) { AppBar(appBar) }
        }
        Column(modifier = Modifier.weight(9f)) {
            state.value.screenViewModel?.let { viewModel ->
                Screen(viewModel, application)
            }
        }
        state.value.bottomBarState?.let { bottomBar ->
            Column(modifier = Modifier.weight(1f)) { BottomBar(bottomBar) }
        }
    }
}
