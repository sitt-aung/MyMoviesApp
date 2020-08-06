package com.sa.mymoviedb.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.sa.mymoviedb.R
import com.sa.mymoviedb.data.vos.MovieVO
import com.sa.mymoviedb.delegates.MovieItemDelegate
import com.sa.mymoviedb.views.viewholders.MovieViewHolder

class MovieListAdapter(private val mDelegate: MovieItemDelegate)
    : BaseRecyclerAdapter<MovieViewHolder, MovieVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view, mDelegate)
    }
}