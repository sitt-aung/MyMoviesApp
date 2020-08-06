package com.sa.mymoviedb.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.sa.mymoviedb.R
import com.sa.mymoviedb.data.vos.CastVO
import com.sa.mymoviedb.views.viewholders.CastViewHolder

class CastListAdapter: BaseRecyclerAdapter<CastViewHolder, CastVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cast, parent, false)
        return CastViewHolder(view)
    }
}