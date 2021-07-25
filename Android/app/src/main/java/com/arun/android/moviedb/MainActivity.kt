package com.arun.android.moviedb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.arun.android.moviedb.components.appbar.AppBar
import com.arun.android.moviedb.components.bottombar.BottomBar
import com.arun.android.moviedb.screens.Screen
import com.arun.moviedb.sdk.AppState
import com.arun.moviedb.sdk.Application
import com.arun.moviedb.sdk.dispatcher.ActionDispatcher

class MainActivity : ComponentActivity() {
    private var application: Application? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launchWhenCreated {
            setContent {
                App()
            }
        }
    }

    override fun onBackPressed() {
        application?.onBackPress()
    }

    @Synchronized
    fun initApplication(updateState: (appState: AppState) -> Unit) {
        if (application == null) {
            application = Application(updateState)
        }
    }

    @Composable
    fun App() {
        val (state, setState) = rememberSaveable { mutableStateOf(null as AppState?) }
        initApplication { appState ->
            setState(appState)
        }
        Column(modifier = Modifier.fillMaxSize()) {
            state?.appBarState?.let { appBar ->
                Column(modifier = Modifier.weight(1f)) { AppBar(appBar) }
            }
            Column(modifier = Modifier.weight(9f)) {
                state?.screenViewModel?.let { viewModel ->
                    Screen(viewModel, application as ActionDispatcher)
                }
            }
            state?.bottomBarState?.let { bottomBar ->
                Column(modifier = Modifier.weight(1f)) { BottomBar(bottomBar, application as ActionDispatcher) }
            }
        }
    }
}
