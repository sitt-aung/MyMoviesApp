package com.sa.mymoviedb.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.sa.mymoviedb.data.vos.PersonVO
import com.sa.mymoviedb.delegates.ActorItemDelegate
import com.sa.mymoviedb.utils.BASE_IMAGE_URL
import kotlinx.android.synthetic.main.item_cast.view.*

class ActorViewHolder(itemView: View, val delegate: ActorItemDelegate)
    : BaseViewHolder<PersonVO>(itemView) {

    override fun bindData(data: PersonVO) {
        Glide.with(itemView.context)
            .load(BASE_IMAGE_URL + data.profilePath)
            .into(itemView.iv_actor)

        itemView.tv_actor_name.text = data.name
    }
}