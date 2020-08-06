package com.sa.mymoviedb.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.sa.mymoviedb.adapters.ShowcaseAdapter
import com.sa.mymoviedb.data.vos.MovieVO
import kotlinx.android.synthetic.main.view_pod_show_cases.view.*

class ShowcaseViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun setData(adapter: ShowcaseAdapter, movies: List<MovieVO>) {
        rv_showcases.adapter = adapter
        adapter.setNewData(movies.toMutableList())
    }
}