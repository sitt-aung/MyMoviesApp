package com.sa.mymoviedb.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.sa.mymoviedb.data.vos.MovieVO
import com.sa.mymoviedb.utils.BASE_IMAGE_URL
import kotlinx.android.synthetic.main.item_showcase.view.*

class ShowcaseViewHolder(itemView: View): BaseViewHolder<MovieVO>(itemView) {

    override fun bindData(data: MovieVO) {
        mData = data
        Glide.with(itemView.context)
            .load(BASE_IMAGE_URL + data.posterPath)
            .into(itemView.iv_showcase)
    }
}