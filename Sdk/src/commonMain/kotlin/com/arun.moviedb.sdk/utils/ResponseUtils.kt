package com.arun.moviedb.sdk.utils

import com.arun.moviedb.sdk.dispatcher.actions.navigation.NavigationAction
import com.arun.moviedb.sdk.dispatcher.actions.navigation.NavigationType
import com.arun.moviedb.sdk.models.actionable.ActionableDiscoverResult
import com.arun.moviedb.sdk.models.discover.DiscoverResponse
import com.arun.moviedb.sdk.models.discover.DiscoverResult
import com.arun.moviedb.sdk.screen.ScreenNames

object ResponseUtils {
    fun processResponse(response: DiscoverResponse): List<DiscoverResult>? {
        return when(response) {
            is DiscoverResponse.Success -> response.success.results
            is DiscoverResponse.Error -> null
        }
    }

    fun convertToActionableResults(results: List<DiscoverResult>?): List<ActionableDiscoverResult>? {
        return results?.map { result ->
            val screenName = ScreenNames.ITEM + "/" + result.id.toString()
            val params = mapOf("data" to result)
            val action = NavigationAction(NavigationType.FORWARD, screenName, params)
            ActionableDiscoverResult(result = result, action = action)
        }
    }
}
