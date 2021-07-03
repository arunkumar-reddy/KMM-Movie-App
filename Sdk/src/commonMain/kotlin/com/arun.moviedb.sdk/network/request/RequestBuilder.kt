package com.arun.moviedb.sdk.network.request

import io.ktor.client.request.*
import io.ktor.http.*

object RequestBuilder {
    fun createRequest(host: String, path: String, queryParams: Map<String, String>? = null): HttpRequestBuilder.() -> Unit {
        val url = URLBuilder(host = host, protocol = URLProtocol.HTTPS, encodedPath = path).build()
        return {
            url(url)
            queryParams?.entries?.forEach {
                parameter(it.key, it.value)
            }
        }
    }
}
