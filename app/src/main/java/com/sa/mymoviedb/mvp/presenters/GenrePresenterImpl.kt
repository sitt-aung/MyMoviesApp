package com.sa.mymoviedb.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.sa.mymoviedb.data.models.MovieModel
import com.sa.mymoviedb.data.models.impls.MovieModelImpl
import com.sa.mymoviedb.mvp.views.GenreListView

class GenrePresenterImpl : GenrePresenter, AbstractBasePresenter<GenreListView>() {

    private val mMovieModel: MovieModel = MovieModelImpl

    override fun onUIReady(lifecycleOwner: LifecycleOwner, movieId: Int) {
        mMovieModel.getMoviesByGenreId(movieId, {
            mView?.displayMoviesByGenre(it.toMutableList())
        }, {

        })
    }

    override fun onTapMovieItem(movieId: Int) {
        mView?.navigateToMovieDetails(movieId)
    }
}