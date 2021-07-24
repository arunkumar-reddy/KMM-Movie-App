package com.arun.moviedb.sdk.models.discover

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport
import kotlin.js.JsName

@Serializable
data class DiscoverSuccess(
    val page: Int,
    val results: List<DiscoverResult>?,
    @SerialName("total_results") val totalResults: Int,
    @SerialName("total_pages") val totalPages: Int
)

@JsExport
@Serializable
data class DiscoverResult(
    @SerialName("poster_path") @JsName("posterPath") val posterPath: String? = null,
    val adult: Boolean? = null,
    val overview: String,
    val id: Int,
    @SerialName("release_date") val releaseDate: String? = null,
    @SerialName("genre_ids") val genreIds: List<Int>? = null,
    @SerialName("original_title") val originalTitle: String? = null,
    @SerialName("original_language") val originalLanguage: String? = null,
    @SerialName("original_name") val originalName: String? = null,
    @SerialName("origin_country") val originCountry: List<String>? = null,
    @JsName("title") val title: String? = null,
    @JsName("name") val name: String? = null,
    @SerialName("backdrop_path") val backdropPath: String?,
    val popularity: Double,
    @SerialName("vote_count") val voteCount: Int? = null,
    @SerialName("vote_average") val voteAverage: Double? = null,
    @SerialName("first_air_date") val firstAirDate: String? = null,
    val video: Boolean? = null
)

@Serializable
data class DiscoverError(
    @SerialName("status_message") val statusMessage: String,
    @SerialName("status_code") val statusCode: Int,
    val success: Boolean
)

sealed class DiscoverResponse() {
    data class Success(val success:DiscoverSuccess): DiscoverResponse()
    data class Error(val error: DiscoverError): DiscoverResponse()
}
