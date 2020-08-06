package com.sa.mymoviedb.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sa.mymoviedb.data.vos.GenreVO
import com.sa.mymoviedb.fragments.GenreListFragment

class GenrePagerAdapter(fragmentActivity: FragmentActivity, val genres : List<GenreVO>) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return genres.size
    }

    override fun createFragment(position: Int): Fragment {
        return GenreListFragment.newInstance(genres[position].id)
    }
}