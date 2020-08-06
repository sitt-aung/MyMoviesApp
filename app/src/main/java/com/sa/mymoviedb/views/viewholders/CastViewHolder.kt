package com.sa.mymoviedb.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.sa.mymoviedb.data.vos.CastVO
import com.sa.mymoviedb.utils.BASE_IMAGE_URL
import kotlinx.android.synthetic.main.item_cast.view.*

class CastViewHolder(itemView: View) : BaseViewHolder<CastVO>(itemView) {

    override fun bindData(data: CastVO) {
        Glide
            .with(itemView.context)
            .load(BASE_IMAGE_URL + data.profilePath)
            .into(itemView.iv_actor)

        itemView.tv_actor_name.text = data.name
    }
}