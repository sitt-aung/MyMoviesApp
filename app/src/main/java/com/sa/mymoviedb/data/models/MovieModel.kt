package com.sa.mymoviedb.data.models

import androidx.lifecycle.LiveData
import com.sa.mymoviedb.data.vos.GenreVO
import com.sa.mymoviedb.data.vos.MovieDetailsVO
import com.sa.mymoviedb.data.vos.MovieVO
import com.sa.mymoviedb.data.vos.PersonVO

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

}