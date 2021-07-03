package com.arun.moviedb.sdk.models.discover

import kotlinx.serialization.Serializable

@Serializable
data class DiscoverSuccess(
    val page: Int,
    val results: List<DiscoverResult>?,
    val totalResults: Int,
    val totalPages: Int
)

@Serializable
data class DiscoverResult(
    val posterPath: String?,
    val adult: Boolean,
    val overview: String,
    val id: Int,
    val releaseDate: String,
    val genreIds: List<Int>,
    val originalTitle: String,
    val originalLanguage: String,
    val title: String,
    val backdropPath: String?,
    val popularity: Double,
    val voteCount: Int,
    val voteAverage: Double,
    val video: Boolean
)

@Serializable
data class DiscoverError(
    val statusMessage: String,
    val statusCode: Int
)

sealed class DiscoverResponse() {
    data class Success(val success:DiscoverSuccess): DiscoverResponse()
    data class Error(val error: DiscoverError): DiscoverResponse()
}
