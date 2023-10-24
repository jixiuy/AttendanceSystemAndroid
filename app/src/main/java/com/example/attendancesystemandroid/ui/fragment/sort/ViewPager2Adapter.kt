package com.example.attendancesystemandroid.ui.fragment.sort

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class ViewPager2Adapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    private var fragments:MutableList<Fragment> = ArrayList()

    fun getItem(index:Int){
        fragments[index]
    }
    init {
        fragments.add(SortFragment(1))
        fragments.add(SortFragment(2))
    }

    override fun getItemCount() = fragments.size
    override fun createFragment(position: Int) = fragments[position]
}