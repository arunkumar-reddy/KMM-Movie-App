package com.arun.moviedb.sdk.models.discover

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DiscoverSuccess(
    val page: Int,
    val results: List<DiscoverResult>?,
    @SerialName("total_results") val totalResults: Int,
    @SerialName("total_pages") val totalPages: Int
)

@Serializable
data class DiscoverResult(
    @SerialName("poster_path") val posterPath: String?,
    val adult: Boolean,
    val overview: String,
    val id: Int,
    @SerialName("release_date") val releaseDate: String,
    @SerialName("genre_ids") val genreIds: List<Int>,
    @SerialName("original_title") val originalTitle: String,
    @SerialName("original_language") val originalLanguage: String,
    val title: String,
    @SerialName("backdrop_path") val backdropPath: String?,
    val popularity: Double,
    @SerialName("vote_count") val voteCount: Int,
    @SerialName("vote_average") val voteAverage: Double,
    val video: Boolean
)

@Serializable
data class DiscoverError(
    @SerialName("status_message") val statusMessage: String,
    @SerialName("status_code") val statusCode: Int
)

sealed class DiscoverResponse() {
    data class Success(val success:DiscoverSuccess): DiscoverResponse()
    data class Error(val error: DiscoverError): DiscoverResponse()
}
