package com.arun.android.moviedb.components.bottombar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arun.android.moviedb.utils.Colors
import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.viewmodels.bottombar.BottomBarItem
import com.arun.moviedb.sdk.viewmodels.bottombar.BottomBarState

@Composable
fun BottomBar(bottomBar: BottomBarState, dispatcher: ActionDispatcher) {
    if (bottomBar.showBottomBar) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
        ) {
            bottomBar.bottomBarItems.forEachIndexed { index, item ->
                val backgroundColor = if (index == bottomBar.selectedIndex) Colors.appYellow else Colors.appBlack
                val textColor = if (index == bottomBar.selectedIndex) Colors.appBlack else Colors.appYellow
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                        .fillMaxHeight()
                        .background(backgroundColor)
                        .clickable { handleBottomBarItemClick(index, bottomBar, dispatcher) },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    BottomBarItem(bottomBarItem = item, color = textColor)
                }
            }
        }
    }
}

@Composable
fun BottomBarItem(bottomBarItem: BottomBarItem, color: Color) {
    Text(
        text = bottomBarItem.title,
        color = color,
        fontSize = 20.sp,
        textAlign = TextAlign.Center
    )
}

private fun handleBottomBarItemClick(index: Int, bottomBarState: BottomBarState, dispatcher: ActionDispatcher) {
    if (index != bottomBarState.selectedIndex) {
        dispatcher.dispatch(bottomBarState.bottomBarItems[index].action)
    }
}
