package com.sa.mymoviedb.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.sa.mymoviedb.R
import com.sa.mymoviedb.activities.MovieDetailsActivity
import com.sa.mymoviedb.adapters.MovieListAdapter
import com.sa.mymoviedb.data.vos.MovieVO
import com.sa.mymoviedb.mvp.presenters.GenrePresenter
import com.sa.mymoviedb.mvp.presenters.GenrePresenterImpl
import com.sa.mymoviedb.mvp.views.GenreListView
import kotlinx.android.synthetic.main.fragment_genre_list.*

class GenreListFragment : Fragment(), GenreListView {

    private lateinit var mMovieAdapter: MovieListAdapter
    private lateinit var mPresenter: GenrePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(GenrePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpAdapter() {
        mMovieAdapter = MovieListAdapter(mPresenter)
        rv_movies_by_genre.adapter = mMovieAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_genre_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpPresenter()
        setUpAdapter()

        val genreId = arguments?.getInt(GENRE_ID_KEY) ?: 0
        mPresenter.onUIReady(this, genreId)
    }

    companion object {
        const val GENRE_ID_KEY = "genre_id"

        fun newInstance(genreId: Int) : GenreListFragment {
            val bundle = Bundle()
            bundle.putInt(GENRE_ID_KEY, genreId)

            val fragment = GenreListFragment()
            fragment.arguments = bundle

            return fragment
        }
    }

    override fun displayMoviesByGenre(movies: List<MovieVO>) {
        mMovieAdapter.setNewData(movies.toMutableList())
    }

    override fun navigateToMovieDetails(movieId: Int) {
        requireActivity().startActivity(MovieDetailsActivity.newIntent(context!!, movieId))
    }

    override fun showErrorMessage(message: String) {
        showErrorMessage(message)
    }
}