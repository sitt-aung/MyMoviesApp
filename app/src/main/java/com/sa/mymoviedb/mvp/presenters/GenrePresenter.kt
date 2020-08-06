package com.sa.mymoviedb.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.sa.mymoviedb.delegates.MovieItemDelegate
import com.sa.mymoviedb.mvp.views.GenreListView

interface GenrePresenter : BasePresenter<GenreListView>, MovieItemDelegate {

    fun onUIReady(lifecycleOwner: LifecycleOwner, movieId: Int)
}