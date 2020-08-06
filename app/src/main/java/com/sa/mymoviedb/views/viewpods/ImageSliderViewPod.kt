package com.sa.mymoviedb.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.sa.mymoviedb.adapters.ImageSliderAdapter
import kotlinx.android.synthetic.main.view_pod_slider.view.*

class ImageSliderViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    fun bindData(imageSliderAdapter: ImageSliderAdapter) {
        vp_image_slider.adapter = imageSliderAdapter
        TabLayoutMediator(tab_layout_indicator, vp_image_slider) {
            tab, position ->
        }.attach()
    }
}