package com.sa.mymoviedb.mvp.views

import com.sa.mymoviedb.data.vos.MovieDetailsVO

interface MovieDetailsView : BaseView {
    fun displayMovieDetails(movie: MovieDetailsVO)
}