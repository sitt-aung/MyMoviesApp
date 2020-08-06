package com.sa.mymoviedb.mvp.presenters

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.sa.mymoviedb.data.models.MovieModel
import com.sa.mymoviedb.data.models.impls.MovieModelImpl
import com.sa.mymoviedb.mvp.views.MovieDetailsView

class MovieDetailsPresenterImpl : MovieDetailsPresenter, AbstractBasePresenter<MovieDetailsView>() {

    private val mMovieModel: MovieModel = MovieModelImpl

    override fun onUIReady(movieId: Int) {
        getMovieDetailsData(movieId)
    }

    private fun getMovieDetailsData(movieId: Int) {
        mMovieModel.getMovieDetails(movieId, onSuccess = {
            mView?.displayMovieDetails(it)
        }, onError = {
            Log.d("errorDetail", it)
        })

    }
}