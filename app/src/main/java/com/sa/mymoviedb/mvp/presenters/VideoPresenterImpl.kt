package com.sa.mymoviedb.mvp.presenters

import android.util.Log
import com.sa.mymoviedb.data.models.MovieModel
import com.sa.mymoviedb.data.models.impls.MovieModelImpl
import com.sa.mymoviedb.mvp.views.VideoView

class VideoPresenterImpl : VideoPresenter, AbstractBasePresenter<VideoView>() {

    var mMovieModel : MovieModel = MovieModelImpl

    override fun onUIReady(movieId: Int) {
        mMovieModel.getVideoByMovieId(movieId, onSuccess = {
            mView?.showVideo(it.key)
        }, onError = {
            Log.d("videoError", it)
        })
    }
}