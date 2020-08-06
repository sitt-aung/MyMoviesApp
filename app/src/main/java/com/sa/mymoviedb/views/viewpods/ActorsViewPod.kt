package com.sa.mymoviedb.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.sa.mymoviedb.adapters.ActorAdapter
import com.sa.mymoviedb.data.vos.PersonVO
import com.sa.mymoviedb.mvp.presenters.MainPresenter
import kotlinx.android.synthetic.main.view_pod_actors.view.*

class ActorsViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun setData(actors : List<PersonVO>, mainPresenter: MainPresenter){
        val actorAdapter = ActorAdapter(mainPresenter)
        rv_actors.adapter = actorAdapter
        actorAdapter.setNewData(actors.toMutableList())
    }
}