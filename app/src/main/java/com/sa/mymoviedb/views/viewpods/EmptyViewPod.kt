package com.sa.mymoviedb.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_pod_empty.view.*

class EmptyViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun setEmptyData(emptyMessage: String, emptyImage: String?) {
        tv_empty.text = emptyMessage

        if (emptyImage != null) {
            Glide.with(context)
                .load(emptyImage)
                .into(iv_empty)
        }
    }
}