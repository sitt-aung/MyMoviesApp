package com.sa.mymoviedb.mvp.views

import com.sa.mymoviedb.data.vos.GenreVO
import com.sa.mymoviedb.data.vos.MovieVO
import com.sa.mymoviedb.data.vos.PersonVO

interface MainView : BaseView {
    fun displayPopularMoviesList(movies: List<MovieVO>)
    fun displayActorsList(actors: List<PersonVO>)
    fun displayGenresList(genres: List<GenreVO>)
    fun enableSwipeRefresh()
    fun disableSwipeRefresh()
    fun showEmptyView()
    fun hideEmptyView()
    fun navigateToMovieDetails(movieId: Int)
}