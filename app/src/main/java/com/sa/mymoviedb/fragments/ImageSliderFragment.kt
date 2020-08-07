package com.sa.mymoviedb.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.sa.mymoviedb.R
import com.sa.mymoviedb.data.models.MovieModel
import com.sa.mymoviedb.data.models.impls.MovieModelImpl
import com.sa.mymoviedb.data.vos.VideoVO
import com.sa.mymoviedb.mvp.presenters.VideoPresenter
import com.sa.mymoviedb.mvp.presenters.VideoPresenterImpl
import com.sa.mymoviedb.mvp.views.VideoView
import com.sa.mymoviedb.utils.BASE_IMAGE_URL
import kotlinx.android.synthetic.main.fragment_image_slider.*

class ImageSliderFragment : Fragment(), VideoView {

    private val mMovieModel: MovieModel = MovieModelImpl
    private lateinit var mPresenter: VideoPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image_slider, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()

        val url = arguments?.getString(IMAGE_URL_KEY)
        val movieId = arguments?.getInt(ID_KEY) ?: 0
        val movieName = arguments?.getString(MOVIE_NAME)

        Glide.with(view.context)
            .load(BASE_IMAGE_URL + url)
            .into(iv_fragment_slider)

        tv_slider_movie_title.text = movieName

        iv_fragment_slider.setOnClickListener {
            mPresenter.onUIReady(movieId)
        }
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(VideoPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    companion object {
        const val IMAGE_URL_KEY = "123"
        const val ID_KEY = "456"
        const val MOVIE_NAME = "333"

        fun newInstance(url: String, id: Int, movieName: String): ImageSliderFragment {
            val fragment = ImageSliderFragment()
            val bundle = Bundle()
            bundle.putString(IMAGE_URL_KEY, url)
            bundle.putInt(ID_KEY, id)
            bundle.putString(MOVIE_NAME, movieName)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun showVideo(key: String) {
        val intent = Intent(Intent.ACTION_VIEW,
        Uri.parse("https://www.youtube.com/watch?v=${key}"))

        startActivity(intent)
    }

    override fun showErrorMessage(message: String) {

    }
}