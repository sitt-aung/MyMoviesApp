package com.sa.mymoviedb.mvp.views

import com.sa.mymoviedb.data.vos.MovieVO

interface GenreListView: BaseView {
    fun displayMoviesByGenre(movies : List<MovieVO>)
    fun navigateToMovieDetails(movieId : Int)
}