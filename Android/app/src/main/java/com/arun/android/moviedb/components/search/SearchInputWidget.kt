package com.arun.android.moviedb.components.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arun.android.moviedb.utils.ColorUtils
import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.dispatcher.actions.navigation.NavigationAction
import com.arun.moviedb.sdk.dispatcher.actions.navigation.NavigationType
import com.arun.moviedb.sdk.screen.ScreenNames

@Composable
fun SearchInputWidget(query: String, dispatcher: ActionDispatcher) {
    val (text, setText) = rememberSaveable { mutableStateOf(query) }
    Row(modifier = Modifier.fillMaxWidth().height(100.dp)) {
        TextField(
            value = text,
            onValueChange = { setText(it) },
            modifier = Modifier.weight(3f)
        )
        Button(
            modifier = Modifier.background(color = ColorUtils.getColorFromHex("#FFC107")).weight(1f),
            onClick = {
                val screenName = ScreenNames.SEARCH + "/" + text
                dispatcher.dispatch(NavigationAction(NavigationType.FORWARD, screenName))
            }
        ) {
            Text(
                text = "Search",
                color = ColorUtils.getColorFromHex("#000000")
            )
        }
    }
}
