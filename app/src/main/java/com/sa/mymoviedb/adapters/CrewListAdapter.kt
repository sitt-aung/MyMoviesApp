package com.sa.mymoviedb.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.sa.mymoviedb.R
import com.sa.mymoviedb.data.vos.CrewVO
import com.sa.mymoviedb.views.viewholders.CrewViewHolder

class CrewListAdapter: BaseRecyclerAdapter<CrewViewHolder, CrewVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_crew, parent, false)
        return CrewViewHolder(view)
    }
}