package com.sa.mymoviedb.data.models

import androidx.lifecycle.LiveData
import com.sa.mymoviedb.data.vos.*

interface MovieModel {

    fun getAllMovies(onError: (String) -> Unit) : LiveData<List<MovieVO>>
    fun getAllMoviesAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

    fun getAllActors(onError: (String) -> Unit): LiveData<List<PersonVO>>
    fun getAllActorsAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

    fun getAllGenres(onError: (String) -> Unit): LiveData<List<GenreVO>>
    fun getAllGenresAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

    fun getMoviesByGenreId(genreId: Int, onSuccess: (movies: List<MovieVO>) -> Unit, onError: (String) -> Unit)

    fun getMovieDetails(movieId: Int, onSuccess: (MovieDetailsVO) -> Unit, onError: (String) -> Unit)
    fun changeFavStatus(personId: Int, isFavorite: Boolean)

    fun getVideoByMovieId(movieId: Int, onSuccess: (VideoVO) -> Unit, onError: (String) -> Unit)
}