package com.sa.mymoviedb.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.sa.mymoviedb.adapters.GenrePagerAdapter
import kotlinx.android.synthetic.main.view_pod_tabs_and_view_pager.view.*

class TabAndViewPagerViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun setData(genrePagerAdapter: GenrePagerAdapter) {
        tab_layout.removeAllTabs()

        genre_view_pager.adapter = genrePagerAdapter
        genre_view_pager.currentItem = 0

        TabLayoutMediator(tab_layout, genre_view_pager) { tab, postion ->
            tab.text = genrePagerAdapter.genres[postion].name
        }.attach()

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                genre_view_pager.currentItem = tab!!.position
            }

        })
    }
}