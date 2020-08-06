package com.sa.mymoviedb.activities

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sa.mymoviedb.R
import com.sa.mymoviedb.adapters.*
import com.sa.mymoviedb.data.vos.GenreVO
import com.sa.mymoviedb.data.vos.MovieVO
import com.sa.mymoviedb.data.vos.PersonVO
import com.sa.mymoviedb.mvp.presenters.MainPresenter
import com.sa.mymoviedb.mvp.presenters.MainPresenterImpl
import com.sa.mymoviedb.mvp.views.MainView
import com.sa.mymoviedb.views.viewpods.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainView {

    private lateinit var mViewPodEmpty: EmptyViewPod
    private lateinit var mPresenter: MainPresenter

    private lateinit var mMovieAdapter: MovieListAdapter
    private lateinit var mGenrePagerAdapter: GenrePagerAdapter
    private lateinit var mShowcaseAdapter: ShowcaseAdapter
    private lateinit var mImageSliderAdapter: ImageSliderAdapter

    private lateinit var mActorsViewPod: ActorsViewPod
    private lateinit var mTabAndViewPagerViewPod: TabAndViewPagerViewPod
    private lateinit var mShowcaseViewPod: ShowcaseViewPod
    private lateinit var mImageSliderViewPod: ImageSliderViewPod

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpPresenter()
        setUpViewPod()
        setUpSwipeRefresh()
        setUpPopularMoviesRecyclerView()
        setUpEmptyViewPod()

        mPresenter.onUIReady(this)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpPopularMoviesRecyclerView() {
        mMovieAdapter = MovieListAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_popular_movies.layoutManager = linearLayoutManager
        rv_popular_movies.adapter = mMovieAdapter
    }

    private fun setUpViewPod() {
        mImageSliderViewPod = vp_slider as ImageSliderViewPod
        mTabAndViewPagerViewPod = vp_movies_by_genre as TabAndViewPagerViewPod
        mActorsViewPod = vp_actors_recyclerview as ActorsViewPod
        mShowcaseViewPod = vp_showcases as ShowcaseViewPod
    }

    private fun setUpSlider(movies: List<MovieVO>) {
        mImageSliderAdapter = ImageSliderAdapter(this)
        mImageSliderAdapter.setData(movies.take(5))
        mImageSliderViewPod.bindData(mImageSliderAdapter)
    }

    override fun displayActorsList(actors: List<PersonVO>) {
        mActorsViewPod.setData(actors, mPresenter)
    }

    override fun displayGenresList(genres: List<GenreVO>) {
        mGenrePagerAdapter = GenrePagerAdapter(this, genres)
        mTabAndViewPagerViewPod.setData(mGenrePagerAdapter)
    }

    override fun displayPopularMoviesList(movies: List<MovieVO>) {
        setUpSlider(movies)
        mMovieAdapter.setNewData(movies.toMutableList())
        mShowcaseAdapter = ShowcaseAdapter()
        mShowcaseViewPod.setData(mShowcaseAdapter, movies.reversed().toMutableList())
    }

    override fun enableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun disableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun showEmptyView() {
        vp_empty.visibility = View.VISIBLE
    }

    override fun hideEmptyView() {
        vp_empty.visibility = View.GONE
    }

    override fun showErrorMessage(message: String) {
        showSnackbar(message)
    }

    override fun navigateToMovieDetails(movieId: Int) {
        startActivity(MovieDetailsActivity.newIntent(this, movieId))
    }

    private fun setUpEmptyViewPod() {
        mViewPodEmpty = vp_empty as EmptyViewPod
        mViewPodEmpty.setEmptyData(
            "There are no movies to show!",
            null
        )
    }

    private fun setUpSwipeRefresh() {
        swipeRefreshLayout.setOnRefreshListener {
            mPresenter.onSwipeRefresh(this)
        }
    }
}