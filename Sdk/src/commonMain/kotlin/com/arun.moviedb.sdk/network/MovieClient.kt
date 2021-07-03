package com.arun.moviedb.sdk.network

import com.arun.moviedb.sdk.models.discover.DiscoverResponse
import com.arun.moviedb.sdk.network.request.RequestBuilder
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

class MovieClient() {
    private val client = HttpClient()

    suspend fun getMostPopularMovies(): DiscoverResponse {
        return makeDiscoverMovieCall()
    }

    suspend fun getMoviesByRegion(): DiscoverResponse {
        return makeDiscoverMovieCall()
    }

    suspend fun getLatestMovies(): DiscoverResponse {
        return makeDiscoverMovieCall()
    }

    private suspend fun makeDiscoverMovieCall(queryParams: Map<String, String>? = null): DiscoverResponse {
        val response: HttpResponse = client.request { RequestBuilder.createRequest(API, DISCOVER_MOVIE_PATH, queryParams) }
        return when (response.status) {
            HttpStatusCode.OK -> DiscoverResponse.Success(response.receive())
            else -> DiscoverResponse.Error(response.receive())
        }
    }

    companion object {
        const val API = "https://api.themoviedb.org/"
        const val DISCOVER_MOVIE_PATH = "3/discover/movie"
        const val DISCOVER_TV_PATH = "3/discover/tv"

        private val movieClient: MovieClient by lazy { MovieClient() }

        fun getInstance(): MovieClient {
            return movieClient
        }
    }
}