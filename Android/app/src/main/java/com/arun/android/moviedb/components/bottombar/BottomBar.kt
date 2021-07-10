package com.arun.android.moviedb.components.bottombar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arun.android.moviedb.utils.ColorUtils
import com.arun.moviedb.sdk.viewmodels.bottombar.BottomBarItem
import com.arun.moviedb.sdk.viewmodels.bottombar.BottomBarState

@Composable
fun BottomBar(bottomBar: BottomBarState) {
    if (bottomBar.showBottomBar) {
        Row(modifier = Modifier.background(ColorUtils.getColorFromHex("#171717")).fillMaxWidth().height(75.dp)) {
            bottomBar.bottomBarItems.forEach {
                Column(
                    modifier = Modifier.weight(1f).align(Alignment.CenterVertically),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    BottomBarItem(bottomBarItem = it)
                }
            }
        }
    }
}

@Composable
fun BottomBarItem(bottomBarItem: BottomBarItem) {
    Text(
        text = bottomBarItem.title,
        color = ColorUtils.getColorFromHex("#FFC107"),
        fontSize = 20.sp,
        textAlign = TextAlign.Center
    )
}
