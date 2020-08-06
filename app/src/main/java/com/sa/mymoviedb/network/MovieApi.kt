package com.sa.mymoviedb.network

import com.sa.mymoviedb.data.vos.MovieDetailsVO
import com.sa.mymoviedb.network.responses.GetGenresResponse
import com.sa.mymoviedb.network.responses.GetMoviesResponse
import com.sa.mymoviedb.network.responses.GetPopularPeopleResponse
import com.sa.mymoviedb.utils.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET(GET_ALL_POPULAR_MOVIES)
    fun getAllPopularMovies(@Query("api_key") apiKey: String): Observable<GetMoviesResponse>

    @GET(GET_POPULAR_PEOPLE)
    fun getPopularActors(@Query("api_key") apiKey: String): Observable<GetPopularPeopleResponse>

    @GET(GET_ALL_GENRES)
    fun getAllGenres(@Query("api_key") apiKey: String): Observable<GetGenresResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetailsById(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String,
        @Query("append_to_response") appendToResponse: String = "credits"
    ): Observable<MovieDetailsVO>

    @GET(GET_MOVIES_BY_GENRE)
    fun getMoviesByGenre(@Query("api_key") apiKey: String, @Query("with_genres") genreId: Int):
            Observable<GetMoviesResponse>
}