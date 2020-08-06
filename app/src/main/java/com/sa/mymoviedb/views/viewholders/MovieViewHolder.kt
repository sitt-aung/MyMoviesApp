package com.sa.mymoviedb.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.sa.mymoviedb.data.vos.MovieVO
import com.sa.mymoviedb.delegates.MovieItemDelegate
import com.sa.mymoviedb.utils.BASE_IMAGE_URL
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieViewHolder(itemView: View, delegate: MovieItemDelegate)
    : BaseViewHolder<MovieVO>(itemView) {

    init {
        itemView.setOnClickListener {
            mData?.let {
                delegate.onTapMovieItem(it.id)
            }
        }
    }

    override fun bindData(data: MovieVO) {
        mData = data
        Glide
            .with(itemView.context)
            .load(BASE_IMAGE_URL + data.posterPath)
            .into(itemView.iv_movie_poster)

        itemView.tv_movie_title.text = data.title
        itemView.tv_vote_average.text = data.voteAverage.toString()
        itemView.rb_movie.rating = data.voteAverage / 2
    }
}