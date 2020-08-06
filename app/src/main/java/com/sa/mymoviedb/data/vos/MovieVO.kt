package com.sa.mymoviedb.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.sa.mymoviedb.persistence.typeconverters.IntArrayListConverter
import com.sa.mymoviedb.persistence.typeconverters.MovieTypeConverter

@Entity(tableName = "movies")
@TypeConverters(IntArrayListConverter::class, MovieTypeConverter::class)
data class MovieVO(
    @PrimaryKey
    @SerializedName("id") var id: Int = 0,
    @SerializedName("popularity") var popularity: Float = 0f,
    @SerializedName("vote_count") var voteCount: Int = 0,
    @SerializedName("video") var video: Boolean = false,
    @SerializedName("poster_path") var posterPath: String = "",
    @SerializedName("adult") var adult: Boolean = false,
    @SerializedName("backdrop_path") var backdropPath: String = "",
    @SerializedName("original_language") var originalLanguage: String = "",
    @SerializedName("original_title") var originalTitle: String = "",
    @SerializedName("genre_ids") var genreIds: List<Int> = listOf(),
    @SerializedName("title") var title: String = "",
    @SerializedName("vote_average") var voteAverage: Float = 0f,
    @SerializedName("overview") var overview: String = "",
    @SerializedName("release_date") var releaseDate: String = ""
)