package com.sa.mymoviedb.mvp.presenters

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.sa.mymoviedb.data.models.MovieModel
import com.sa.mymoviedb.data.models.impls.MovieModelImpl
import com.sa.mymoviedb.mvp.views.MainView

class MainPresenterImpl : MainPresenter, AbstractBasePresenter<MainView>() {

    private val mMovieModel: MovieModel = MovieModelImpl

    override fun onUIReady(lifecycleOwner: LifecycleOwner) {
        getAllData(lifecycleOwner)
    }

    override fun onSwipeRefresh(lifecycleOwner: LifecycleOwner) {
        getAllData(lifecycleOwner)
    }

    override fun onTapMovieItem(movieId: Int) {
        mView?.navigateToMovieDetails(movieId)
    }

    override fun onTapFavorite(personId: Int, favorite: Boolean) {
        mMovieModel.changeFavStatus(personId, favorite)
    }

    private fun getAllData(lifecycleOwner: LifecycleOwner) {

        mView?.enableSwipeRefresh()

        mMovieModel.getAllMovies {
            Log.d("movies error", it)
        }.observe(lifecycleOwner, Observer {
            it?.let {
                mView?.displayPopularMoviesList(it)
            }
        })

        mMovieModel.getAllGenres {
            Log.d("genres error", it)
        }.observe(lifecycleOwner, Observer {
            it?.let {
                mView?.displayGenresList(it)
            }
        })

        mMovieModel.getAllActors {
            Log.d("actors error", it)
        }.observe(lifecycleOwner, Observer {
            it?.let {
                mView?.displayActorsList(it)
            }
        })

        mView?.disableSwipeRefresh()
    }

//    private fun getPopularMoviesData(lifecycleOwner: LifecycleOwner) {
//        mView?.enableSwipeRefresh()
//
//        mMovieModel.getAllMovies(onError = {
//            mView?.disableSwipeRefresh()
//            mView?.showEmptyView()
//            mView?.showErrorMessage(it)
//        }).observe( lifecycleOwner, Observer {
//            mView?.disableSwipeRefresh()
//            if (it.isEmpty()) {
//                mView?.showEmptyView()
//            } else {
//                mView?.hideEmptyView()
//                mView?.displayPopularMoviesList(it)
//            }
//        })
//    }
}