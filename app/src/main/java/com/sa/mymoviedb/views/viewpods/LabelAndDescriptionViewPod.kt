package com.sa.mymoviedb.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.view_pod_label_and_description.view.*

class LabelAndDescriptionViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun setData(label: String, description: String) {
        tv_label.text = label
        tv_description.text = description
    }
}