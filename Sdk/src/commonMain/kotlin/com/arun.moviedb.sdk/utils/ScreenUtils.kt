package com.arun.moviedb.sdk.utils

import com.arun.moviedb.sdk.screen.ScreenNames

object ScreenUtils {
    fun getSearchQueryFromScreenName(screenName: String): String? {
        if (screenName.startsWith(ScreenNames.SEARCH)) {
            var query = screenName.removePrefix(ScreenNames.SEARCH)
            query = query.removePrefix("/")
            query = query.removeSuffix("/")
            return query.ifEmpty { null }
        }
        return null
    }

    fun getItemFromScreenName(screenName: String): String? {
        if (screenName.startsWith(ScreenNames.ITEM)) {
            var item = screenName.removePrefix(ScreenNames.ITEM + "/")
            item = item.removeSuffix("/")
            return item.ifEmpty { null }
        }
        return null
    }
}
