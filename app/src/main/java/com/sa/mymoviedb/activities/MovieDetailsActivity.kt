package com.sa.mymoviedb.activities

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.chip.Chip
import com.sa.mymoviedb.R
import com.sa.mymoviedb.adapters.CastListAdapter
import com.sa.mymoviedb.adapters.CrewListAdapter
import com.sa.mymoviedb.data.vos.GenreVO
import com.sa.mymoviedb.data.vos.MovieDetailsVO
import com.sa.mymoviedb.mvp.presenters.MovieDetailsPresenter
import com.sa.mymoviedb.mvp.presenters.MovieDetailsPresenterImpl
import com.sa.mymoviedb.mvp.views.MovieDetailsView
import com.sa.mymoviedb.utils.BASE_IMAGE_URL
import com.sa.mymoviedb.views.viewpods.LabelAndDescriptionViewPod
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.collapse_movie_details.*

class MovieDetailsActivity : BaseActivity(), MovieDetailsView {

    private lateinit var mPresenter: MovieDetailsPresenter
    private lateinit var mCastAdapter: CastListAdapter
    private lateinit var mCrewAdapter: CrewListAdapter
    var genreStrList = ""

    companion object {

        const val MOVIE_ID_EXTRA = "Movie Id Extra"

        fun newIntent(context: Context, movieId: Int): Intent {
            val intent = Intent(context, MovieDetailsActivity::class.java)
            intent.putExtra(MOVIE_ID_EXTRA, movieId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        setUpPresenter()
        setUpCastRecyclerView()
        setUpCrewRecyclerView()

        val movieId = intent.getIntExtra(MOVIE_ID_EXTRA, 0)
        mPresenter.onUIReady(movieId)
    }

    private fun bindGenres(genres: List<GenreVO>) {
        for (genre in genres) {
            val chip = Chip(this).apply {
                text = genre.name
                textSize = 12f
                setTextColor(Color.WHITE)
                setBackgroundColor(Color.DKGRAY)
                genreStrList += genre.name + " "
            }
            chip_group_genres.addView(chip)
        }
        chip_group_genres
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this)
            .get(MovieDetailsPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpCastRecyclerView() {
        mCastAdapter = CastListAdapter()
        rv_casts.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_casts.adapter = mCastAdapter
    }

    private fun setUpCrewRecyclerView() {
        mCrewAdapter = CrewListAdapter()
        rv_crews.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_crews.adapter = mCrewAdapter
    }

    override fun displayMovieDetails(movie: MovieDetailsVO) {
        Glide
            .with(this)
            .load(BASE_IMAGE_URL + movie.backdropPath)
            .into(iv_movie_poster)

        tv_movie_name.text = movie.originalTitle
        chip_year.text = movie.releaseDate.take(4)
        rb_movie.rating = movie.voteAverage / 2
        tv_vote_average.text = movie.voteAverage.toString()
        tv_vote_count.text = movie.voteCount.toString() + " VOTES"
        tv_movie_runtime.text = movie.getMovieRunTime()
        tv_storyline.text = movie.overview
        bindGenres(movie.genres)

        mCastAdapter.setNewData(movie.credits.cast.toMutableList())
        mCrewAdapter.setNewData(movie.credits.crew.toMutableList())

        (vp_original_title as LabelAndDescriptionViewPod)
            .setData("Original Title", movie.originalTitle)
        (vp_type as LabelAndDescriptionViewPod)
            .setData("Type", genreStrList)
        (vp_production as LabelAndDescriptionViewPod)
            .setData("Production", movie.productionCountries[0].name)
        (vp_premier as LabelAndDescriptionViewPod)
            .setData("Premier", movie.releaseDate)
        (vp_description as LabelAndDescriptionViewPod)
            .setData("Description", movie.overview)

    }

    override fun showErrorMessage(message: String) {
        showSnackbar(message)
    }
}