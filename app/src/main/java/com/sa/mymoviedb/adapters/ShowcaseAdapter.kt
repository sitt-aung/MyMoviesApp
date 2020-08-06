package com.sa.mymoviedb.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.sa.mymoviedb.R
import com.sa.mymoviedb.data.vos.MovieVO
import com.sa.mymoviedb.views.viewholders.ShowcaseViewHolder

class ShowcaseAdapter: BaseRecyclerAdapter<ShowcaseViewHolder, MovieVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowcaseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_showcase,parent,false)

        return ShowcaseViewHolder(view)
    }
}