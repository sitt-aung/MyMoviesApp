package com.sa.mymoviedb.mvp.presenters

import com.sa.mymoviedb.mvp.views.BaseView

interface BasePresenter<T: BaseView> {
    fun initPresenter(view: T)
}