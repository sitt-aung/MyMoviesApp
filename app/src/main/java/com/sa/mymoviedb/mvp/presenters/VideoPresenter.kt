package com.sa.mymoviedb.mvp.presenters

import com.sa.mymoviedb.mvp.views.VideoView

interface VideoPresenter : BasePresenter<VideoView> {
    fun onUIReady(movieId: Int)
}