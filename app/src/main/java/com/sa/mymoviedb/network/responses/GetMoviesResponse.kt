package com.sa.mymoviedb.network.responses

import com.google.gson.annotations.SerializedName
import com.sa.mymoviedb.data.vos.MovieVO

data class GetMoviesResponse(
    @SerializedName("page") val page: Int = 0,
    @SerializedName("total_results") val totalResults: Int = 0,
    @SerializedName("total_pages") val totalPages: Int = 0,
    @SerializedName("results") val results: ArrayList<MovieVO>? = null
) {
    fun isResponseOk() : Boolean = (results != null) && (totalResults > 0)
}