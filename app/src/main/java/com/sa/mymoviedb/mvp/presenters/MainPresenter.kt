package com.sa.mymoviedb.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.sa.mymoviedb.delegates.ActorItemDelegate
import com.sa.mymoviedb.delegates.MovieItemDelegate
import com.sa.mymoviedb.mvp.views.MainView

interface MainPresenter : MovieItemDelegate,
    BasePresenter<MainView>, ActorItemDelegate {

    fun onUIReady(lifecycleOwner: LifecycleOwner)
    fun onSwipeRefresh(lifecycleOwner: LifecycleOwner)
}