package com.sa.mymoviedb.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.sa.mymoviedb.data.vos.CrewVO
import com.sa.mymoviedb.utils.BASE_IMAGE_URL
import kotlinx.android.synthetic.main.item_crew.view.*

class CrewViewHolder(itemView: View): BaseViewHolder<CrewVO>(itemView) {

    override fun bindData(data: CrewVO) {
          Glide
            .with(itemView.context)
            .load(BASE_IMAGE_URL + data.profilePath)
            .into(itemView.iv_crew)

        itemView.tv_crew_name.text = data.name
    }
}