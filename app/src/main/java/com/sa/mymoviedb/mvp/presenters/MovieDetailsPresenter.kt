package com.sa.mymoviedb.mvp.presenters

import com.sa.mymoviedb.mvp.views.MovieDetailsView

interface MovieDetailsPresenter : BasePresenter<MovieDetailsView> {
    fun onUIReady(movieId: Int)
}