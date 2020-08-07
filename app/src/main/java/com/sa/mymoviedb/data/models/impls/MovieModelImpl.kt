package com.sa.mymoviedb.data.models.impls

import androidx.lifecycle.LiveData
import com.sa.mymoviedb.data.models.BaseModel
import com.sa.mymoviedb.data.models.MovieModel
import com.sa.mymoviedb.data.vos.*
import com.sa.mymoviedb.utils.API_KEY
import com.sa.mymoviedb.utils.EM_NO_INTERNET_CONNECTION
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object MovieModelImpl : MovieModel, BaseModel() {

    override fun getAllMovies(onError: (String) -> Unit): LiveData<List<MovieVO>> {
        return mMoviesDB.movieDao().getAllPopularMovies()
    }

    override fun getAllMoviesAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit) {
        mMovieApi.getAllPopularMovies(API_KEY)
            .map { it.results?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let {
                    mMoviesDB.movieDao().insertAll(it)
                }
            }, {
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getAllActors(onError: (String) -> Unit): LiveData<List<PersonVO>> {
        return mMoviesDB.personDao().getAllActors()
    }

    override fun getAllActorsAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit) {
        mMovieApi.getPopularActors(API_KEY)
            .map { it.results.toList() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let {
                    mMoviesDB.personDao().insertAll(it)
                }
            }, {
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getAllGenres(onError: (String) -> Unit): LiveData<List<GenreVO>> {
        return mMoviesDB.genreDao().getAllGenres()
    }

    override fun getAllGenresAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit) {
        mMovieApi.getAllGenres(API_KEY)
            .map { it.genres.toList() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let {
                    mMoviesDB.genreDao().insertAll(it)
                }
            }, {
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getMoviesByGenreId(
        genreId: Int,
        onSuccess: (movies: List<MovieVO>) -> Unit,
        onError: (String) -> Unit
    ) {
        mMovieApi.getMoviesByGenre(API_KEY, genreId)
            .map { it.results?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                onSuccess(it)
            }, {
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getMovieDetails(
        movieId: Int,
        onSuccess: (MovieDetailsVO) -> Unit,
        onError: (String) -> Unit
    ) {
        mMovieApi.getMovieDetailsById(movieId, API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                onSuccess(it)
            }, {
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun changeFavStatus(personId: Int, isFavorite: Boolean) {
        mMoviesDB.personDao().changeFavoriteState(personId, isFavorite)
    }

    override fun getVideoByMovieId(
        movieId: Int,
        onSuccess: (VideoVO) -> Unit,
        onError: (String) -> Unit
    ) {
        mMovieApi.getVideosById(movieId, API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                onSuccess(it.results[0])
            }, {
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

}