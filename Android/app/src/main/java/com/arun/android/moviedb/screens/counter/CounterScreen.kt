package com.arun.android.moviedb.screens.counter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.viewmodels.counter.CounterViewModel

@Composable
fun CounterScreen(counterViewModel: CounterViewModel, dispatcher: ActionDispatcher) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text("The Current Count is: " + counterViewModel.counter)
        Button(onClick = { dispatcher.dispatch(counterViewModel.incrementAction) }) {
            Text("Increment Counter")
        }
        Button(onClick = { dispatcher.dispatch(counterViewModel.decrementAction) }) {
            Text("Decrement Counter")
        }
        Button(onClick = { dispatcher.dispatch(counterViewModel.submitAction) }) {
            Text("Submit")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCounterScreen() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text("The Current Count is: 0")
        Button(onClick = {}) {
            Text("Increment Counter")
        }
        Button(onClick = {}) {
            Text("Decrement Counter")
        }
        Button(onClick = {}) {
            Text("Submit")
        }
    }
}
