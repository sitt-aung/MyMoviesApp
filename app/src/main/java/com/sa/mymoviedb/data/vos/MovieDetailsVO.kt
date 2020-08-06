package com.sa.mymoviedb.data.vos

import com.google.gson.annotations.SerializedName

data class MovieDetailsVO (
    @SerializedName("id") var id: Int = 0,
    @SerializedName("adult") var adult: Boolean = false,
    @SerializedName("backdrop_path") var backdropPath: String = "",
    @SerializedName("genres") var genres: List<GenreVO> = listOf(),
    @SerializedName("original_title") var originalTitle: String = "",
    @SerializedName("overview") var overview: String = "",
    @SerializedName("popularity") var popularity: Float = 0f,
    @SerializedName("poster_path") var posterPath: String = "",
    @SerializedName("production_countries") var productionCountries: ArrayList<ProductionCountryVO> = arrayListOf(),
    @SerializedName("release_date") var releaseDate: String = "",
    @SerializedName("runtime") var runtime: Int = 0,
    @SerializedName("tagline") var tagline: String = "",
    @SerializedName("title") var title: String = "",
    @SerializedName("vote_average") var voteAverage: Float = 0f,
    @SerializedName("vote_count") var voteCount: Int = 0,
    @SerializedName("credits") var credits: CreditVO = CreditVO()
) {
    fun getMovieRunTime() : String {
        return String.format("%dh %02dmin", runtime / 60, runtime % 60)
    }
}

data class ProductionCountryVO(
    @SerializedName("iso_3166_1") var iso31661: String = "",
    @SerializedName("name") var name: String = ""
)

data class CreditVO(
    @SerializedName("cast") var cast: List<CastVO> = listOf(),
    @SerializedName("crew") var crew: List<CrewVO> = listOf()
)