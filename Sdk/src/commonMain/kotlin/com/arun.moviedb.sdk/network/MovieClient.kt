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
        val queryParams = createQueryParams()
        queryParams["sort_by"] = "popularity.desc"
        return fetchData(DISCOVER_MOVIE_PATH, queryParams)
    }

    suspend fun getMoviesByRegion(): DiscoverResponse {
        val queryParams = createQueryParams()
        queryParams["region"] = "IN"
        return fetchData(DISCOVER_MOVIE_PATH, queryParams)
    }

    suspend fun getLatestMovies(): DiscoverResponse {
        val queryParams = createQueryParams()
        queryParams["sort_by"] = "release_date.desc"
        return fetchData(DISCOVER_MOVIE_PATH, queryParams)
    }

    suspend fun getMostPopularTvShows(): DiscoverResponse {
        val queryParams = createQueryParams()
        queryParams["sort_by"] = "popularity.desc"
        return fetchData(DISCOVER_TV_PATH, queryParams)
    }

    suspend fun getLatestTvShows(): DiscoverResponse {
        val queryParams = createQueryParams()
        queryParams["sort_by"] = "release_date.desc"
        return fetchData(DISCOVER_TV_PATH, queryParams)
    }

    private suspend fun fetchData(path: String, queryParams: Map<String, String>? = null): DiscoverResponse {
        val response: HttpResponse = client.request { RequestBuilder.createRequest(API, path, queryParams) }
        return when (response.status) {
            HttpStatusCode.OK -> DiscoverResponse.Success(response.receive())
            else -> DiscoverResponse.Error(response.receive())
        }
    }

    private fun createQueryParams(): MutableMap<String, String> {
        val queryParams = mutableMapOf<String, String>()
        queryParams["api_key"] = API_KEY
        return queryParams
    }

    companion object {
        const val API = "https://api.themoviedb.org/"
        const val API_KEY = "def588ca30d1e24ad80f41e04197ec3f"
        const val DISCOVER_MOVIE_PATH = "3/discover/movie"
        const val DISCOVER_TV_PATH = "3/discover/tv"

        private val movieClient: MovieClient by lazy { MovieClient() }

        fun getInstance(): MovieClient {
            return movieClient
        }
    }
}
