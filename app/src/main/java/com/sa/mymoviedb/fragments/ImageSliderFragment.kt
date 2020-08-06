package com.sa.mymoviedb.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.sa.mymoviedb.R
import com.sa.mymoviedb.adapters.MovieListAdapter
import com.sa.mymoviedb.mvp.presenters.GenrePresenter
import com.sa.mymoviedb.utils.BASE_IMAGE_URL
import kotlinx.android.synthetic.main.fragment_image_slider.*

class ImageSliderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image_slider, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url = arguments?.getString(IMAGE_URL_KEY)
        val movieId = arguments?.getInt(ID_KEY)

        Glide.with(view.context)
            .load(BASE_IMAGE_URL + url)
            .into(iv_fragment_slider)
    }

    companion object {
        const val IMAGE_URL_KEY = "123"
        const val ID_KEY = "456"

        fun newInstance(url: String, id: Int): ImageSliderFragment {
            val fragment = ImageSliderFragment()
            val bundle = Bundle()
            bundle.putString(IMAGE_URL_KEY, url)
            bundle.putInt(ID_KEY, id)
            fragment.arguments = bundle
            return fragment
        }
    }
}