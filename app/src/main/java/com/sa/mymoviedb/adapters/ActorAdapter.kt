package com.sa.mymoviedb.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.sa.mymoviedb.R
import com.sa.mymoviedb.data.vos.PersonVO
import com.sa.mymoviedb.delegates.ActorItemDelegate
import com.sa.mymoviedb.views.viewholders.ActorViewHolder

class ActorAdapter(val delegate: ActorItemDelegate)
    : BaseRecyclerAdapter<ActorViewHolder, PersonVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cast, parent,false)
        return ActorViewHolder(view, delegate)
    }
}