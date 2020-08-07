package com.sa.mymoviedb.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sa.mymoviedb.data.vos.MovieVO
import com.sa.mymoviedb.fragments.ImageSliderFragment

class ImageSliderAdapter(fragmentActivity: FragmentActivity)
    : FragmentStateAdapter(fragmentActivity) {

    var movies: List<MovieVO> = listOf()

    fun setData(popularMovies: List<MovieVO>) {
        movies = popularMovies
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun createFragment(position: Int): Fragment {
        return ImageSliderFragment.newInstance(
            movies[position].posterPath,
            movies[position].id,
            movies[position].originalTitle
        )
    }
}