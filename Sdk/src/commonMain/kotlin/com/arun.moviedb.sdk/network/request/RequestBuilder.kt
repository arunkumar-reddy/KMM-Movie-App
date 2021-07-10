package com.arun.moviedb.sdk.network.request

object RequestBuilder {
    fun createRequestUrl(host: String, path: String, queryParams: Map<String, String>? = null): String {
        var url = "https://$host/$path?"
        val keys = queryParams?.keys
        keys?.forEachIndexed { index, key ->
            url += "${key}=${queryParams[key]}"
            url += if (index != keys.size - 1) "&" else ""
        }
        return url
    }
}
